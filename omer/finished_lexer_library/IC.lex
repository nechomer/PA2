package ic.parser;
import ic.parser.LexicalError;
import ic.parser.LibraryParserSym;
/*********** Definitions ***********/
%%
%cup
%class Lexer
%public
%yylexthrow LexicalError
%type Token
%unicode
%line
%column
%{
	StringBuffer string = new StringBuffer();

	// save the last line and column of state
	private int lLine, lCol;

	private int getCurrentLine() {
		return yyline+1;
	}

	private int getCurrentColumn() {
		return yycolumn+1;
	}

	private void lastPos() {
		lLine = getCurrentLine();
		lCol = getCurrentColumn();  
	}

	// if flag == true => then use lastPos else currentPos
	private Token token(int id, String tag, Object value, boolean flag) {
		if(flag)
			return new Token(id,lLine,lCol,tag,value);
		else
			return new Token(id,getCurrentLine(),getCurrentColumn(),tag,value);
	}

	private Token token(int id, String tag, boolean flag) {
		if(flag)
			return new Token(id,lLine,lCol,tag);
		else
			return new Token(id,getCurrentLine(),getCurrentColumn(),tag);
	}

	private void Error(String token, boolean flag) throws LexicalError {
		if(flag)
			throw new LexicalError(lLine,lCol,token);
		else
			throw new LexicalError(getCurrentLine(),getCurrentColumn(),token);
	}

%}

/******** Macros *********/

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace     = {LineTerminator} | [ \t]

LineComment     = "//" {InputCharacter}* {LineTerminator}

IdentifierCharacter = [a-zA-Z0-9_]
ClassIdentifier = [A-Z]{IdentifierCharacter}*
RegularIdentifier = [a-z]{IdentifierCharacter}*

DecIntegerLiteral = (0 | [1-9][0-9]*)

//**************************** keywords ***********************************
classKeyword = "class"
extendsKeyword = "extends"
staticKeyword = "static" 
voidKeyword = "void"
intKeyword = "int"
booleanKeyword = "boolean"
stringKeyword = "string"
returnKeyword = "return"
ifKeyword = "if"
elseKeyword = "else"
whileKeyword = "while"
breakKeyword = "break"
continueKeyword = "continue"
thisKeyword = "this"
newKeyword = "new"
lengthKeyword = "length"
trueKeyword = "true"
falseKeyword = "false"
nullKeyword = "null"


//**************************** Operators ***********************************
leftBracketOperator = "["
rightBracketOperator = "]"
leftparenOperator = "("
rightparenOperator = ")"
dotOperator = "."
minusOperator = "-"
notOperator = "!"
multOperator = "*"
divOperator = "/"
moduluOperator = "%"
plusOperator = "+"
ltOperator = "<"
lteqOperator = "<="
gtOperator = ">"
gteqOperator = ">="
eqeqOperator = "=="
neqOperator = "!="
andandOperator = "&&"
ororOperator = "||"
eqOperator = "="

// StringCharacter:  ASCII codes incl 32 - 126 + " and \ + escape sequence: \", \\, \t, \n
StringCharacter = ([\040-\041\043-\133\135-\176] | "\\\"" | "\\\\" | "\\t" | "\\n")

//**************************** Stracture ***********************************
leftBracesStracture = "{"
rightBracesStracture = "}"
semiStracture = ";"
comaStracture = ","


%state STRING, TRADITIONAL_COMMENT

%%

/********* Rules and Actions **********/

<YYINITIAL> {

/* keywords */

{classKeyword}					{ return token(LibraryParserSym.CLASS, yytext(), false); }
{extendsKeyword}				{ return token(LibraryParserSym.EXTENDS, yytext(), false); }
{staticKeyword}					{ return token(LibraryParserSym.STATIC, yytext(), false); } 
{voidKeyword}					{ return token(LibraryParserSym.VOID, yytext(), false); }
{intKeyword}					{ return token(LibraryParserSym.INTEGER, yytext(), false); }
{booleanKeyword}				{ return token(LibraryParserSym.BOOLEAN, yytext(), false); }
{stringKeyword}					{ return token(LibraryParserSym.STRING, yytext(), false); }
{returnKeyword}					{ return token(LibraryParserSym.RETURN, yytext(), false); }
{ifKeyword}						{ return token(LibraryParserSym.IF, yytext(), false); }
{elseKeyword}					{ return token(LibraryParserSym.ELSE, yytext(), false); }
{whileKeyword}					{ return token(LibraryParserSym.WHILE, yytext(), false); }
{breakKeyword}					{ return token(LibraryParserSym.BREAK, yytext(), false); }
{continueKeyword}				{ return token(LibraryParserSym.CONTINUE, yytext(), false); }
{thisKeyword}					{ return token(LibraryParserSym.THIS, yytext(), false); }
{newKeyword}					{ return token(LibraryParserSym.NEW, yytext(), false); }
{lengthKeyword}					{ return token(LibraryParserSym.LENGTH, yytext(), false); }
{trueKeyword}					{ return token(LibraryParserSym.BOOLEAN_LITERAL, yytext(), Boolean.valueOf(yytext()), false); }
{falseKeyword}					{ return token(LibraryParserSym.BOOLEAN_LITERAL, yytext(), Boolean.valueOf(yytext()), false); }
{nullKeyword}					{ return token(LibraryParserSym.NULL_LITERAL, yytext(), false); }


/* identifiers */

"_" {IdentifierCharacter}*     { Error(yytext(), false);}
{RegularIdentifier}            { return token(LibraryParserSym.IDENTIFIER, "Identifier", yytext(), false); }
{ClassIdentifier}              { return token(LibraryParserSym.CLASS_ID, "CLASS_ID", yytext(), false); }


/* literals */

0+ {DecIntegerLiteral}         { Error(yytext(), false); }
{DecIntegerLiteral}            { return token(LibraryParserSym.INTEGER_LITERAL, "INTEGER", new Integer(yytext()), false); }
\"                             { lastPos(); string.setLength(0); yybegin(STRING); }


/* operators */

{leftBracketOperator}			{ return token(LibraryParserSym.LBRACKET, yytext(), false); }
{rightBracketOperator}			{ return token(LibraryParserSym.RBRACKET, yytext(), false); }
{leftparenOperator}				{ return token(LibraryParserSym.LPAREN, yytext(), false); }
{rightparenOperator}			{ return token(LibraryParserSym.RPAREN, yytext(), false); }
{dotOperator}					{ return token(LibraryParserSym.DOT, yytext(), false); }
{minusOperator}					{ return token(LibraryParserSym.MINUS, yytext(), false); }
{notOperator}					{ return token(LibraryParserSym.NOT, yytext(), false); }
{multOperator}					{ return token(LibraryParserSym.MULT, yytext(), false); }
{divOperator}					{ return token(LibraryParserSym.DIV, yytext(), false); }
{moduluOperator}				{ return token(LibraryParserSym.MODULU, yytext(), false); }
{plusOperator}					{ return token(LibraryParserSym.PLUS, yytext(), false); }
{ltOperator}					{ return token(LibraryParserSym.LT, yytext(), false); }
{lteqOperator}					{ return token(LibraryParserSym.LTEQ, yytext(), false); }
{gtOperator}					{ return token(LibraryParserSym.GT, yytext(), false); }
{gteqOperator} 					{ return token(LibraryParserSym.GTEQ, yytext(), false); }
{eqeqOperator} 					{ return token(LibraryParserSym.EQEQ, yytext(), false); }
{neqOperator} 					{ return token(LibraryParserSym.NEQ, yytext(), false); }
{andandOperator} 				{ return token(LibraryParserSym.AND, yytext(), false); }
{ororOperator} 					{ return token(LibraryParserSym.OR, yytext(), false); }
{eqOperator} 					{ return token(LibraryParserSym.EQ, yytext(), false); }

                                                           
/* structure */  

{leftBracesStracture}			{ return token(LibraryParserSym.LBRACE, yytext(), false); }
{rightBracesStracture}			{ return token(LibraryParserSym.RBRACE, yytext(), false); }
{semiStracture}					{ return token(LibraryParserSym.SEMI, yytext(), false); }
{comaStracture}					{ return token(LibraryParserSym.COMA, yytext(), false); }


/* comments */

{LineComment}             		{ /* ignore */ }         
"/*"                           	{ lastPos(); yybegin(TRADITIONAL_COMMENT); }     

                                                             
/* whitespace */

{WhiteSpace}                   	{ /* ignore */ }
}


<STRING> {
\"                             	{ yybegin(YYINITIAL); return token(LibraryParserSym.STRING_LITERAL, "STRING", string.toString(), true); }
{StringCharacter}+             	{ string.append(yytext()); }
<<EOF>>                        	{ Error(yytext(), true); }
}


<TRADITIONAL_COMMENT> {
[^\*]                          	{ /* ignore */ }
"*/"                           	{ yybegin(YYINITIAL); }
"*"                            	{ /* ignore */ }
<<EOF>>                        	{ Error(yytext(), true); }
}


/* error fallback */
[^]                           	{ Error(yytext(), false); }

/*regular EOF*/
<<EOF>>							{ return token(LibraryParserSym.EOF, yytext(), false); }
