package fun.parser.cky

import java.util.regex.Pattern
import fun.parser.Parser
import fun.grammar.Grammar
import fun.grammar.Rule

/**
 * Implementation of the CKY algorithm, a bottom-up parse of a CNF grammar, with optional probability.
 * Instead of optimizing the parse by limiting it to the rule with the highest probability
 * for any given non-terminal, this generates all possible parses (even with probability),
 * and then sorts by probability (if any), for the sake of debugging.
 */
class CkyParser extends Parser {

    List<List<List<CkyParse>>> table = [].withDefault {[].withDefault {[]}}

    /**
     * Constructs a CkyParser, parsing the given line with the given Grammar.
     *
     * @param line the line of words to parse (i.e., a sentence)
     * @param g the grammar to use for the parse
     * @param lexer (optional) a regex identifying each separate word (i.e., token) in the line
     */
    CkyParser(String line, Grammar g, Pattern lexer = ~/\w+/) {
        super(line, g, lexer)
        g.normalize()     // CKY requires CNF, so just in case g is not already
        parse()
    }

    /**
     * Does the CKY parse on this parser's line of words, according to its grammar.
     * This is the CKY algorithm from the textbook.
     */
    private void parse() {

        for (j in 1..words.size()) {    // for each word (or column from left)

            // The cell on the diagonal gets all terminal lexicon parses (A -> word) for this word.
            String word = words[j-1]    // j-1 adjusts the algorithm to the 0-based list
            List<Rule> lexicon = grammar.lexiconOf(word)
            List<CkyParse> lexiconParses = lexicon.collect {new CkyParse(it)}
            table[j-1][j].addAll(lexiconParses)     // diagonal (starting from row 0 and column 1)

            // Each cell in this column, from above the diagonal to row 0 (i.e., table[i][j]),
            // gets all possible combinations of binary parses (A -> B C) on the parses so far.
            for (int i = j-2; i >= 0; i--) {    // using Java for() loop to skip j == 1 (the first column)
                for (k in i+1..j-1) {           // for each combination for [i,k] of row i to [k,j] of column j
                    for (B in table[i][k]) {        // for each B = [i,k]
                        for (C in table[k][j]) {    // for each C = [k,j]
                            def matching = grammar.rulesTo(B.rule.nonTerminal, C.rule.nonTerminal)  // all A -> B C
                            table[i][j].addAll(matching.collect {new CkyParse(it, B, C)})
                        }
                    }
                }
            }
        }
    }

    /**
     * @return a list of roots of all accepted, full parse trees, or the empty list if none are accepted
     */
    List<CkyParse> getCompletedParses() {
        def fullParses = table[0][words.size()]                                         // all A for [0,N]
        def sParses = fullParses.findAll {it.rule.nonTerminal == grammar.startSymbol}   // all S for [0,N]
        if (grammar.hasAttachments()) {
            sParses = sParses.sort {-it.probability}      // most-probable first
        }
        sParses
    }

    /**
     * Renders the whole parse table, for debugging.  (This is not required for assignment 4.)
     *
     * @return a rendering of the parse table along the diagonals, from the terminals to the apex
     */
    @Override
    String toString() {
        def s = ''
        for (j in 1..table.size()) {
            for (i in 0..table.size()-j) {
                def parses = table[i][i+j]
                if (grammar.hasAttachments()) {
                    parses = parses.sort {-it.probability}
                }
                s += "table[$i][${i+j}] = $parses\n"
            }
        }
        s
    }

    /**
     * For running from the command line (from the "src" dir),
     * this loads a grammar file and uses it to parse lines from stdin.
     *
     * @param args  command line arguments
     */
    static void main(String[] args) {

        if (args.size() != 1) {
            System.err.println "usage: groovy parser/cky/CkyParser grammarFile < sentenceLines"
            System.exit 1
        }

        def g = new Grammar(new File(args[0]))
        System.in.eachLine {line ->
            println "\n$line: " + new CkyParser(line, g).prettyCompletedParsesString
            null    // just avoiding a warning about not returning a value from eachLine
        }
    }
}
