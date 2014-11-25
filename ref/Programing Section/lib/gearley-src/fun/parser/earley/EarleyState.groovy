package fun.parser.earley

import fun.grammar.Attachment
import fun.grammar.Rule
import fun.grammar.Word;
import groovy.transform.EqualsAndHashCode
import fun.fol.lambda.SingleTerm
import fun.fol.lambda.TermList
import fun.parser.Parse
import fun.parser.Tree


/**
 * Chart entries in an Earley parse.
 * These are also nodes (i.e., sub-trees) in the parse tree.
 * As such, completed components are part of the identity; this differs from the textbook algorithm,
 * which could map different completed components to the same state (as an optimization).
 */
@EqualsAndHashCode(excludes = ['function', 'name'])
class EarleyState implements Parse {

	Rule rule
	int dotIdx
	int inputStartIdx, inputDotIdx
	Word terminal
	List<EarleyState> components = []
	String function     // not part of the identity
	String name         // not part of the identity

	EarleyState(Rule rule, int dotIdx, List inputIdxPair, String function) {
		this.rule = rule
		this.dotIdx = dotIdx
		(inputStartIdx, inputDotIdx) = inputIdxPair
		this.function = function
	}

	boolean isComplete() {
		dotIdx == rule.symbols.size()
	}

	String getB() {
		assert !complete
		rule.symbols[dotIdx]
	}

	/**
	 * Factory method for a new EarleyState with the dot advanced over one completed component.
	 *
	 * @param component completed for advance
	 * @return new EarleyState
	 */
	EarleyState completer(EarleyState component) {
		assert !complete && component.complete
		def result = new EarleyState(rule, dotIdx+1, [inputStartIdx, component.inputDotIdx], 'completer')
		if (dotIdx > 0) {
			result.components += components[0..<dotIdx]
		}
		result.components[dotIdx] = component
		result
	}

	/**
	 * Factory method for a new EarleyState with the dot advanced over one terminal symbol.
	 * This is an optimization of the textbook's optimization of scanner(),
	 * to support terminal symbols in non-terminal-form rules (i.e., in lexicon, or part of speech).
	 *
	 * @return new EarleyState
	 */
	EarleyState advancing(Word word) {
		assert !complete && b in rule.terminals
		def result = new EarleyState(rule, dotIdx+1, [inputStartIdx, inputDotIdx+1], 'advancing')
		if (dotIdx > 0) {
			result.components += components[0..<dotIdx]
		}
		Rule rule0 = new Rule(nonTerminal: null, symbols: [word.tag], attachment: null, grammar: null)
		def ns = new EarleyState(rule0, 0, [0,0], 'advance');    // just the terminal symbol here
		ns.terminal = word
		result.components[dotIdx] = ns
		result
	}

	/**
	 * @return render of the subtree rooted at this node (recursively) in bracket format
	 */
	@Override
	String toString() {
		def subtrees = []
		for (i in 0..<rule.symbols.size()) {
			def s = rule.symbols[i]
			subtrees << (i < dotIdx && s in rule.nonTerminalSymbols ? components[i] : s)
		}
		"[$name ${rule.nonTerminal} ${subtrees.join(' ')} ($inputStartIdx,$inputDotIdx)$attachmentStr]"
	}

	private String getAttachmentStr() {
		if (rule.attachment) {
			def p = Attachment.canonicalProbability(probability)    // of current subtree, not the rule.attachment's
			Closure cl = rule.attachment.lambdaClosure
			return cl ? " {$p, ${cl(this)}}" : " {$p}"
		} else {
			return ''
		}
	}

	String toFlatString() {
		[name, ruleWithDot, [inputStartIdx, inputDotIdx], function].join('\t')
	}

	String prettyPrint(int level = 0) {
		def indentBy = ' ' * 4
		def indent = '\n' + (indentBy * level)
		if (components.find {it}) {     // has nested states
			def subtrees = []
			for (i in 0..<rule.symbols.size()) {
				def c = components[i]
				subtrees << (c ? c.prettyPrint(level+1) : indent + indentBy + rule.symbols[i])
			}
			return "$indent[${rule.nonTerminal}${subtrees.join('')}$indent$attachmentStr]"
		} else {
			return "$indent[${rule.nonTerminal} ${terminal}]"
			//return "$indent[${rule.nonTerminal} ${rule.symbols.join(' ')}$attachmentStr]${terminal}"
		}
	}

	Tree parseTree() {
		if (components.find {it}) {   // has nested states
			def subtrees = components.collect { it.parseTree() }
			return new Tree(new Word(rule.nonTerminal), subtrees);
		}
		else if (rule.nonTerminal != null) {
			def subtrees = terminal == null ? [] : [new Tree(terminal)];
			return new Tree(new Word(rule.nonTerminal), subtrees);
		}
		else {
			return new Tree(terminal)
		}
	}

	private String getRuleWithDot() {
		def withDot = [] + rule.symbols
		withDot.addAll(dotIdx, "∙")     // insert
		"${rule.nonTerminal} -> ${withDot.join(' ')}"
	}

	BigDecimal getProbability() {
		def p = rule.probability
		if (p != null) {
			for (int i = 0; i < dotIdx; i++) {
				if (rule.symbols[i] in rule.nonTerminalSymbols) {
					p *= components[i].probability
				} else {
					assert !components[i]
				}
			}
		}
		p
	}

	SingleTerm getLambda() {
		def x = rule.attachment?.lambdaClosure?.call(this)
		if (x instanceof TermList) {
			assert x.size() == 1        // S -> foo wraps in TermList
			return (SingleTerm) x[0]
		} else {
			return (SingleTerm) x
		}
	}
}
