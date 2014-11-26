
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20140808 (SVN rev 54)
//----------------------------------------------------

package ic.parser;

import ic.ast.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20140808 (SVN rev 54) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\014\000\002\002\007\000\002\002\004\000\002\005" +
    "\003\000\002\005\004\000\002\004\011\000\002\010\003" +
    "\000\002\010\004\000\002\007\004\000\002\011\003\000" +
    "\002\011\003\000\002\011\003\000\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\031\000\004\014\004\001\002\000\002\001\002\000" +
    "\004\002\006\001\002\000\004\002\000\001\002\000\004" +
    "\004\010\001\002\000\004\015\011\001\002\000\012\021" +
    "\016\022\017\023\022\024\021\001\002\000\006\005\014" +
    "\015\011\001\002\000\006\005\uffff\015\uffff\001\002\000" +
    "\004\002\001\001\002\000\006\005\ufffe\015\ufffe\001\002" +
    "\000\004\020\ufff9\001\002\000\004\020\ufff8\001\002\000" +
    "\002\001\002\000\004\020\ufff6\001\002\000\004\020\ufff7" +
    "\001\002\000\004\010\024\001\002\000\012\021\016\022" +
    "\017\023\022\024\021\001\002\000\014\011\031\021\016" +
    "\022\017\023\022\024\021\001\002\000\004\020\030\001" +
    "\002\000\014\011\ufffc\021\ufffc\022\ufffc\023\ufffc\024\ufffc" +
    "\001\002\000\014\011\ufffa\021\ufffa\022\ufffa\023\ufffa\024" +
    "\ufffa\001\002\000\004\012\033\001\002\000\014\011\ufffb" +
    "\021\ufffb\022\ufffb\023\ufffb\024\ufffb\001\002\000\006\005" +
    "\ufffd\015\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\031\000\004\002\004\001\001\000\004\003\006\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\006\004\012\005\011\001\001\000\004\011\017\001" +
    "\001\000\004\004\014\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\004\006\022\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\010\007\026\010\024\011" +
    "\025\001\001\000\006\007\031\011\025\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  /** Scan to get the next Symbol. */
  public java_cup.runtime.Symbol scan()
    throws java.lang.Exception
    {

	Token t = lexer.next_token();
	if (printTokens)
		System.out.println(t.getLine() + ":" + t);
	return t; 

    }


	/** Causes the parsr to print every token it reads.
	 * This is useful for debugging.
	 */
	public boolean printTokens;
	
	private Lexer lexer;

	public Parser(Lexer lexer) {
		super(lexer);
		this.lexer = lexer;
	}
	
	public int getLine() {
		return lexer.getLineNumber();
	}
	
	public void syntax_error(Symbol s) {
		Token tok = (Token) s;
		System.out.println("Line " + tok.getLine()+": Syntax error; unexpected " + tok);
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // icclass ::= CLASS CLASS_ID LBRACE method_list RBRACE 
            {
              ICClass RESULT =null;
		int cileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int ciright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String ci = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int mlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mlright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		MethodList ml = (MethodList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = new ICClass(getLine(), ci, null, ml)
              CUP$parser$result = parser.getSymbolFactory().newSymbol("icclass",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= icclass EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ICClass start_val = (ICClass)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // method_list ::= stmethod 
            {
              MethodList RESULT =null;
		int smleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int smright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		StaticMethod sm = (StaticMethod)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new MethodList(sm); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("method_list",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // method_list ::= method_list stmethod 
            {
              MethodList RESULT =null;
		int mlleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int mlright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		MethodList ml = (MethodList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int smleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int smright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		StaticMethod sm = (StaticMethod)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 ml.addMethod(sm); RESULT = ml; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("method_list",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // stmethod ::= STATIC type METHOD_ID LPAREN formal_list RPAREN SEMI 
            {
              StaticMethod RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-5)).value;
		int mileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int miright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String mi = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int flleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int flright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		FormalList fl = (FormalList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		RESULT = new StaticMethod(t,mi,fl,null) 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("stmethod",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // formal_list ::= formal 
            {
              FormalList RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formal f = (Formal)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new FormalList(f); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formal_list",6, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // formal_list ::= formal_list formal 
            {
              FormalList RESULT =null;
		int flleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int flright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		FormalList fl = (FormalList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Formal f = (Formal)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 fl.addFormal(f); RESULT = fl; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formal_list",6, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // formal ::= type IDENTIFIER 
            {
              Formal RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Type t = (Type)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		java.lang.String i = (java.lang.String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = new Formal(t,i)
              CUP$parser$result = parser.getSymbolFactory().newSymbol("formal",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // type ::= INTEGER_LITERAL 
            {
              Type RESULT =null;
		int illeft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int ilright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		java.lang.Number il = (java.lang.Number)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = new Type(getLine())
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // type ::= BOOLEAN_LITERAL 
            {
              Type RESULT =null;
		RESULT = new Type(getLine())
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // type ::= STRING_LITERAL 
            {
              Type RESULT =null;
		RESULT = new Type(getLine())
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // type ::= NULL_LITERAL 
            {
              Type RESULT =null;
		RESULT = new Type(getLine())
              CUP$parser$result = parser.getSymbolFactory().newSymbol("type",7, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}