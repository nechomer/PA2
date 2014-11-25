package fun.parser

import fun.grammar.Word;
import groovy.json.JsonOutput;



public class Tree
{
    public Word root
    public List<Tree> subtrees

    Tree() { root = null; subtrees = [] }

    Tree(Word root) { this.root = root; subtrees = [] }

    Tree(Word root, List<Tree> subtrees) 
    { this.root = root; this.subtrees = subtrees }

	/**
	 * Pretty Printing!
	 * @return
	 */
    String prettyPrint(int level = 0)
    {
        def indentBy = ' ' * 4
        def indent0= '\n' + (indentBy * level)
        def indent = '\n' + (indentBy * (level + 1))
        def subs = subtrees.collect { it.prettyPrint(level + 1) }
        if (subs) {
            if (subtrees.find { it.subtrees })
                return "[$root $indent${subs.join(indent)}$indent0]"
            else
                return "[$root  ${subs.join(' ')} ]"
        }
        else {
            return "[$root]"
        }
    }
	
	/**
	 * List representation in the style of LISP
	 * @return a list of the form [root, [..child1..], [..child2..], ... ]
	 */
	List toLispStyle()
	{
		List l = [root.toString()]
		l.addAll(subtrees.collect { it.toLispStyle() })
		return l
	}
	
	/**
	 * JSON!
	 * @return a JSON string
	 */
	String toJson()
	{
		return JsonOutput.toJson(toLispStyle());
	}
}
