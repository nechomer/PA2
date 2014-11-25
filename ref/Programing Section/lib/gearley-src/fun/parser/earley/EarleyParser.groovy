package fun.parser.earley

import java.util.regex.Pattern
import fun.parser.Parser
import fun.grammar.Grammar
import fun.grammar.Rule
import fun.grammar.Word;

/**
 * Implementation of the Earley parser, from the textbook.
 */
class EarleyParser extends Parser {

    List<List<EarleyState>> chart = [].withDefault {[]}

    /**
     * Constructs an EarleyParser, parsing the given line with the given Grammar.
     *
     * @param line the line of words to parse (e.g., a sentence)
     * @param g the grammar to use for the parse
     * @param lexer (optional) a regex identifying each separate word (i.e., token) in the line
     */
    EarleyParser(String line, Grammar g, Pattern lexer = ~/\w+/) {
        super(line, g, lexer)
        parse()
    }

    /**
     * Constructs an EarleyParser for the given Grammar, where the input is
     * already tokenized.
     *
     * @param line a list of words (tokens)
     * @param g the grammar to use for the parse
     */
    EarleyParser(Iterable<? extends Word> line, Grammar g) {
        super(line, g);
		parse();
    }

    /**
     * Parses this parser's line of words, according to its grammar.
     * This is the Earley algorithm from the textbook, which has an optimization
     * of the original algorithm to avoid adding a lexicon's whole set of terminals
     * to the chart.  But, I enhanced that to support FOL, to also allow terminals
     * in non-terminal rules (i.e., non-lexicons), with the advancing() method.
     */
    private void parse() {
        enqueue(dummyStartState, chart[0])
		def t = grammar.terminals
		def nt = grammar.nonTerminals
        for (i in 0..words.size()) {
            int j = 0
            while (j < chart[i].size()) {   // allowing chart[i] to grow as j goes through it
                def state = chart[i][j++]
                if (state.complete) {
                    completer(state)
                } else {
                    if (grammar.isLexicon(state.b)) {
                        scanner(state)
                    } else if (state.b in t /*grammar.terminals*/) {
                        advancing(state)
                    } else {
                        predictor(state)
                    }
                }
            }
        }
    }

    /**
     * This is used to start the parse chart, but is not advanced to completion.
     *
     * @return the dummy start state
     */
    private getDummyStartState() {
        Rule dummy = Rule.valuesOf("γ -> ${grammar.startSymbol}", grammar)[0]
        new EarleyState(dummy, 0, [0, 0], 'dummy start state')
    }

    /**
     * Enqueue a new state for every rule that, if completed, would advance the dot in the given state.
     *
     * @param state to look forward (i.e., top-down) on how to advance
     */
    private void predictor(EarleyState state) {
        def B = state.b
        def j = state.inputDotIdx
        for (rule in grammar.rulesFor(B)) {
            enqueue(new EarleyState(rule, 0, [j, j], 'predictor'), chart[j])
        }
    }

    /**
     * Works backwards from the next input word,
     * to enqueue a state for every matching terminal rule.
     * This is an optimization by the textbook, limiting it to the actual input word,
     * to avoid enqueueing a state for every terminal in the lexicon.
     *
     * @param state with the dot on a terminal rule
     */
    private void scanner(EarleyState state) {
        def B = state.b
        def j = state.inputDotIdx
        if (j < words.size()) {
            def word = words[j].tag
            def rule = grammar.lexiconOf(word).find {it.nonTerminal == B}
            if (rule) {
                assert rule.nonTerminal == B && rule.symbols == [word]
                def nextState = new EarleyState(rule, 1, [j, j+1], 'scanner')
                nextState.terminal = words[j]
                enqueue(nextState, chart[j+1])
            }
        }
    }

    /**
     * Fixes the textbook's optimization to support grammars with terminals in non-terminal rules, like FOL.
     * This advances the state over the next input word, if the state's next symbol matches it.
     *
     * @param state with the dot on a terminal symbol
     */
    private void advancing(EarleyState state) {
        def j = state.inputDotIdx
        if (j < words.size() && words[j].tag == state.b) {
            enqueue(state.advancing(words[j]), chart[j+1])
        }
    }

    /**
     * Advances states satisfied by the completion of the given state.
     *
     * @param state completed state
     */
    private void completer(EarleyState state) {
        def B = state.rule.nonTerminal
        def j = state.inputStartIdx
        def k = state.inputDotIdx
        def incompleteStates = chart[j].findAll {!it.complete && it != dummyStartState}
        for (EarleyState match in incompleteStates.findAll {it.b == B && it.inputDotIdx == j}) {
            enqueue(match.completer(state), chart[k])
        }
    }

    private enqueueSequence = 0

    /**
     * Adds a state to the given chartEntry, if it is not already in it, assigning the state a sequential name.
     *
     * @param state to add to chartEntry
     * @param chartEntry in which to enqueue the state
     */
    private void enqueue(EarleyState state, List<EarleyState> chartEntry) {
        if (!(state in chartEntry)) {
            state.name = "S${enqueueSequence++}"
            chartEntry << state
        }
    }

    /**
     *
     * @return a list of roots of all accepted, full parse trees, or the empty list if none are accepted
     */
    @Override
    List<EarleyState> getCompletedParses() {
        def N = words.size()
        def fullParses = chart[N].findAll {it.complete && it.inputStartIdx == 0 && it.inputDotIdx == N} // [0,N]
        def sParses = fullParses.findAll {it.rule.nonTerminal == grammar.startSymbol}   // all S for [0,N]
        if (grammar.hasAttachments()) {
            sParses = sParses.sort {-it.probability}      // most-probable first
        }
        sParses
    }

	class PostMortem {
		public Collection<EarleyState> states;
		public Word token;
		public Collection<String> expecting;
	}
	
	PostMortem diagnoseError() {
		def N = words.size()
		def j;
		for (j = N; j > 0 && chart[j].size() == 0; j--) ;
		def pm = new PostMortem()
		pm.states = chart[j];
		pm.token = (j == N-1) ? null : words[j];
		pm.expecting = 
			new HashSet(chart[j].findAll { !it.isComplete() }.collect { it.getB() }
				.findAll { grammar.isTerminal(it)}).sort()
		return pm
	}
	
    /**
     * Renders the whole parse chart, for debugging.
     *
     * @return a flat rendering of the parse chart (i.e., not nested or treed)
     */
    @Override
    String toString() {
        (0..<chart.size()).collect { i ->
            "Chart[$i]\n\t" + chart[i]*.toFlatString().join('\n\t')
        }.join('\n\n')
    }

    /**
     * For running from the command line (from the "src" dir),
     * this loads a grammar file and uses it to parse lines from stdin.
     *
     * @param args  command line arguments
     */
    static void main(String[] args) {

        if (args.size() != 1) {
            System.err.println "usage: groovy parser/earley/EarleyParser grammarFile < sentenceLines"
            System.exit 1
        }

        def g = new Grammar(new File(args[0]))
        System.in.eachLine {line ->
            println "\n$line: " + new EarleyParser(line, g).prettyCompletedParsesString
            null    // just avoiding a warning about not returning a value from eachLine
        }
    }
}
