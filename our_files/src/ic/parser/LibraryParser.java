
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20140808 (SVN rev 54)
//----------------------------------------------------

package ic.parser;

import ic.*;
import ic.parser.*;
import ic.ast.*;
import ic.ast.expr.*;
import ic.ast.methods.*;
import ic.ast.stmt.*;
import ic.ast.types.*;
import java_cup.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20140808 (SVN rev 54) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class LibraryParser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return LibraryParserSym.class;
}

  /** Default constructor. */
  public LibraryParser() {super();}

  /** Constructor which sets the default scanner. */
  public LibraryParser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public LibraryParser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\022\000\002\002\004\000\002\002\004\000\002\002" +
    "\003\000\002\003\007\000\002\003\006\000\002\005\003" +
    "\000\002\005\004\000\002\004\010\000\002\004\011\000" +
    "\002\010\003\000\002\010\003\000\002\007\003\000\002" +
    "\007\005\000\002\006\004\000\002\011\003\000\002\011" +
    "\003\000\002\011\003\000\002\011\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\004\024\005\001\002\000\006\002\044\024" +
    "\005\001\002\000\004\025\007\001\002\000\006\002\uffff" +
    "\024\uffff\001\002\000\004\004\010\001\002\000\006\005" +
    "\012\016\011\001\002\000\012\017\024\020\017\021\020" +
    "\022\023\001\002\000\006\002\ufffd\024\ufffd\001\002\000" +
    "\006\005\015\016\011\001\002\000\006\005\ufffc\016\ufffc" +
    "\001\002\000\006\002\ufffe\024\ufffe\001\002\000\006\005" +
    "\ufffb\016\ufffb\001\002\000\006\013\ufff3\023\ufff3\001\002" +
    "\000\006\013\ufff1\023\ufff1\001\002\000\006\013\034\023" +
    "\ufff8\001\002\000\004\023\025\001\002\000\006\013\ufff2" +
    "\023\ufff2\001\002\000\004\023\ufff7\001\002\000\004\006" +
    "\026\001\002\000\012\007\027\020\017\021\020\022\023" +
    "\001\002\000\004\010\042\001\002\000\006\007\037\011" +
    "\036\001\002\000\006\013\034\023\033\001\002\000\006" +
    "\007\ufff6\011\ufff6\001\002\000\006\007\ufff4\011\ufff4\001" +
    "\002\000\004\014\035\001\002\000\006\013\ufff0\023\ufff0" +
    "\001\002\000\010\020\017\021\020\022\023\001\002\000" +
    "\004\010\040\001\002\000\006\005\ufff9\016\ufff9\001\002" +
    "\000\006\007\ufff5\011\ufff5\001\002\000\006\005\ufffa\016" +
    "\ufffa\001\002\000\006\002\001\024\001\001\002\000\004" +
    "\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\042\000\006\002\003\003\005\001\001\000\004\003" +
    "\042\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\004\013\005\012\001\001\000\006\010" +
    "\021\011\020\001\001\000\002\001\001\000\004\004\015" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\006\031\007\027\011\030\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\006\040\011\030\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$LibraryParser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$LibraryParser$actions(this);
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
    return action_obj.CUP$LibraryParser$do_action(act_num, parser, stack, top);
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
	currentLine = t.getLine();
	if (printTokens)
		System.out.println(t.getLine() + ":" + t);
	return t; 

    }


	/** Causes the parsr to print every token it reads.
	 * This is useful for debugging.
	 */
	
	public boolean printTokens;
	
	private Lexer lexer;
	private int currentLine = 0;

	public LibraryParser(Lexer lexer) {
		super(lexer);
		this.lexer = lexer;
	}
	
	public int getLine() {
		return currentLine;
	}
	
	public void syntax_error(Symbol s) {
		Token tok = (Token) s;
		System.out.println("Line " + tok.getLine()+": Syntax error; unexpected " + tok);
	}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$LibraryParser$actions {
  private final LibraryParser parser;

  /** Constructor */
  CUP$LibraryParser$actions(LibraryParser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$LibraryParser$do_action_part00000000(
    int                        CUP$LibraryParser$act_num,
    java_cup.runtime.lr_parser CUP$LibraryParser$parser,
    java.util.Stack            CUP$LibraryParser$stack,
    int                        CUP$LibraryParser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$LibraryParser$result;

      /* select the action based on the action number */
      switch (CUP$LibraryParser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= program icclass 
            {
              Program RESULT =null;

              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).right;
		Program start_val = (Program)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).value;
		RESULT = start_val;
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$LibraryParser$parser.done_parsing();
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // program ::= icclass 
            {
              Program RESULT =null;

              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // icclass ::= CLASS CLASS_ID LBRACE method_block RBRACE 
            {
              ICClass RESULT =null;
		int cileft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)).left;
		int ciright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)).right;
		java.lang.String ci = (java.lang.String)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)).value;
		int mbleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).left;
		int mbright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).right;
		List<Method> mb = (List<Method>)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).value;
		 RESULT = new ICClass(getLine(), ci, null, mb); System.out.println("finish icclass "+ci+ " : " + mb); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("icclass",1, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // icclass ::= CLASS CLASS_ID LBRACE RBRACE 
            {
              ICClass RESULT =null;
		int cileft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).left;
		int ciright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).right;
		java.lang.String ci = (java.lang.String)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).value;
		 RESULT = new ICClass(getLine(), ci, null, null); System.out.println("finish icclass "+ci); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("icclass",1, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // method_block ::= stmethod 
            {
              List<Method> RESULT =null;
		int smleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).left;
		int smright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).right;
		StaticMethod sm = (StaticMethod)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.peek()).value;
		 List<Method> mb = new ArrayList<Method>(); mb.add(sm); RESULT = mb; System.out.println("crate function block with methods mb= "+mb+" added function sm = "+sm);
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("method_block",3, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // method_block ::= method_block stmethod 
            {
              List<Method> RESULT =null;
		int mbleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).left;
		int mbright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).right;
		List<Method> mb = (List<Method>)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).value;
		int smleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).left;
		int smright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).right;
		StaticMethod sm = (StaticMethod)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.peek()).value;
		 mb.add(sm); RESULT = mb; System.out.println("added function to function block with methods mb= "+mb+" added function sm = "+sm); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("method_block",3, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // stmethod ::= STATIC methodType IDENTIFIER LPAREN RPAREN SEMI 
            {
              StaticMethod RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)).right;
		PrimitiveType t = (PrimitiveType)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)).right;
		java.lang.String id = (java.lang.String)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-3)).value;
		RESULT = new StaticMethod(t,id,null,null); System.out.println("finish function not args "+id); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("stmethod",2, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-5)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // stmethod ::= STATIC methodType IDENTIFIER LPAREN formal_block RPAREN SEMI 
            {
              StaticMethod RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-5)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-5)).right;
		PrimitiveType t = (PrimitiveType)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-5)).value;
		int idleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)).right;
		java.lang.String id = (java.lang.String)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-4)).value;
		int fbleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).left;
		int fbright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).right;
		List<Formal> fb = (List<Formal>)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).value;
		RESULT = new StaticMethod(t,id,fb,null); System.out.println("finish function "+id+" : "+fb); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("stmethod",2, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-6)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // methodType ::= formalType 
            {
              PrimitiveType RESULT =null;
		int ftleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).left;
		int ftright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).right;
		PrimitiveType ft = (PrimitiveType)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.peek()).value;
		 RESULT = ft; 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("methodType",6, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // methodType ::= VOID 
            {
              PrimitiveType RESULT =null;
		 RESULT = new PrimitiveType(getLine(), DataTypes.VOID); System.out.println("type void"); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("methodType",6, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // formal_block ::= formal 
            {
              List<Formal> RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).right;
		Formal f = (Formal)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.peek()).value;
		 List<Formal> fb = new ArrayList<Formal>(); fb.add(f); RESULT = fb; System.out.println("added formal block : fb= "+fb+" : f= "+f); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formal_block",5, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // formal_block ::= formal_block COMA formal 
            {
              List<Formal> RESULT =null;
		int fbleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).left;
		int fbright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).right;
		List<Formal> fb = (List<Formal>)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).value;
		int fleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).right;
		Formal f = (Formal)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.peek()).value;
		 fb.add(f); RESULT = fb; System.out.println("added formal to block fb= "+fb+" : f= "+f);
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formal_block",5, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // formal ::= formalType IDENTIFIER 
            {
              Formal RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).left;
		int tright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).right;
		PrimitiveType t = (PrimitiveType)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)).value;
		int ileft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()).right;
		java.lang.String i = (java.lang.String)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.peek()).value;
		 RESULT = new Formal(t,i); System.out.println("added formal t= "+t+" : i= "+i);
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formal",4, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-1)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // formalType ::= INTEGER 
            {
              PrimitiveType RESULT =null;
		 RESULT = new PrimitiveType(getLine(), DataTypes.INT); System.out.println("added primitive integer"); 
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formalType",7, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // formalType ::= BOOLEAN 
            {
              PrimitiveType RESULT =null;
		 RESULT = new PrimitiveType(getLine(), DataTypes.BOOLEAN); System.out.println("added primitive boolean");
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formalType",7, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // formalType ::= STRING 
            {
              PrimitiveType RESULT =null;
		 RESULT = new PrimitiveType(getLine(), DataTypes.STRING); System.out.println("added primitive string");
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formalType",7, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // formalType ::= formalType LBRACKET RBRACKET 
            {
              PrimitiveType RESULT =null;
		int ftleft = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).left;
		int ftright = ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).right;
		PrimitiveType ft = (PrimitiveType)((java_cup.runtime.Symbol) CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)).value;
		 ft.incrementDimension(); RESULT = ft; System.out.println("added array ft=" + ft);
              CUP$LibraryParser$result = parser.getSymbolFactory().newSymbol("formalType",7, ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.elementAt(CUP$LibraryParser$top-2)), ((java_cup.runtime.Symbol)CUP$LibraryParser$stack.peek()), RESULT);
            }
          return CUP$LibraryParser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$LibraryParser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$LibraryParser$do_action(
    int                        CUP$LibraryParser$act_num,
    java_cup.runtime.lr_parser CUP$LibraryParser$parser,
    java.util.Stack            CUP$LibraryParser$stack,
    int                        CUP$LibraryParser$top)
    throws java.lang.Exception
    {
              return CUP$LibraryParser$do_action_part00000000(
                               CUP$LibraryParser$act_num,
                               CUP$LibraryParser$parser,
                               CUP$LibraryParser$stack,
                               CUP$LibraryParser$top);
    }
}

}
