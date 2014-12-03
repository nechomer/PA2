package ic.parser;
import ic.parser.LexicalError;
import ic.parser.ProgramParserSym;
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
StringCharacter = ([\040-\041\043-\133\135-\176])

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

{classKeyword}					{ return token(ProgramParserSym.CLASS, yytext(), false); }
{extendsKeyword}				{ return token(ProgramParserSym.EXTENDS, yytext(), false); }
{staticKeyword}					{ return token(ProgramParserSym.STATIC, yytext(), false); } 
{voidKeyword}					{ return token(ProgramParserSym.VOID, yytext(), false); }
{intKeyword}					{ return token(ProgramParserSym.INTEGER, yytext(), false); }
{booleanKeyword}				{ return token(ProgramParserSym.BOOLEAN, yytext(), false); }
{stringKeyword}					{ return token(ProgramParserSym.STRING, yytext(), false); }
{returnKeyword}					{ return token(ProgramParserSym.RETURN, yytext(), false); }
{ifKeyword}						{ return token(ProgramParserSym.IF, yytext(), false); }
{elseKeyword}					{ return token(ProgramParserSym.ELSE, yytext(), false); }
{whileKeyword}					{ return token(ProgramParserSym.WHILE, yytext(), false); }
{breakKeyword}					{ return token(ProgramParserSym.BREAK, yytext(), false); }
{continueKeyword}				{ return token(ProgramParserSym.CONTINUE, yytext(), false); }
{thisKeyword}					{ return token(ProgramParserSym.THIS, yytext(), false); }
{newKeyword}					{ return token(ProgramParserSym.NEW, yytext(), false); }
{lengthKeyword}					{ return token(ProgramParserSym.LENGTH, yytext(), false); }
{trueKeyword}					{ return token(ProgramParserSym.TRUE_LITERAL, yytext(), Boolean.valueOf(yytext()), false); }
{falseKeyword}					{ return token(ProgramParserSym.FALSE_LITERAL, yytext(), Boolean.valueOf(yytext()), false); }
{nullKeyword}					{ return token(ProgramParserSym.NULL_LITERAL, yytext(), false); }


/* identifiers */

"_" {IdentifierCharacter}*     { Error(yytext(), false);}
{RegularIdentifier}            { return token(ProgramParserSym.IDENTIFIER, "Identifier", yytext(), false); }
{ClassIdentifier}              { return token(ProgramParserSym.CLASS_ID, "CLASS_ID", yytext(), false); }


/* literals */

0+ {DecIntegerLiteral}         { Error(yytext(), false); }
{DecIntegerLiteral}            { return token(ProgramParserSym.INTEGER_LITERAL, "INTEGER", new Integer(yytext()), false); }
\"                             { lastPos(); string.setLength(0); yybegin(STRING); }


/* operators */

{leftBracketOperator}			{ return token(ProgramParserSym.LBRACKET, yytext(), false); }
{rightBracketOperator}			{ return token(ProgramParserSym.RBRACKET, yytext(), false); }
{leftparenOperator}				{ return token(ProgramParserSym.LPAREN, yytext(), false); }
{rightparenOperator}			{ return token(ProgramParserSym.RPAREN, yytext(), false); }
{dotOperator}					{ return token(ProgramParserSym.DOT, yytext(), false); }
{minusOperator}					{ return token(ProgramParserSym.MINUS, yytext(), false); }
{notOperator}					{ return token(ProgramParserSym.NOT, yytext(), false); }
{multOperator}					{ return token(ProgramParserSym.MULT, yytext(), false); }
{divOperator}					{ return token(ProgramParserSym.DIV, yytext(), false); }
{moduluOperator}				{ return token(ProgramParserSym.MODULU, yytext(), false); }
{plusOperator}					{ return token(ProgramParserSym.PLUS, yytext(), false); }
{ltOperator}					{ return token(ProgramParserSym.LT, yytext(), false); }
{lteqOperator}					{ return token(ProgramParserSym.LTEQ, yytext(), false); }
{gtOperator}					{ return token(ProgramParserSym.GT, yytext(), false); }
{gteqOperator} 					{ return token(ProgramParserSym.GTEQ, yytext(), false); }
{eqeqOperator} 					{ return token(ProgramParserSym.EQEQ, yytext(), false); }
{neqOperator} 					{ return token(ProgramParserSym.NEQ, yytext(), false); }
{andandOperator} 				{ return token(ProgramParserSym.AND, yytext(), false); }
{ororOperator} 					{ return token(ProgramParserSym.OR, yytext(), false); }
{eqOperator} 					{ return token(ProgramParserSym.EQ, yytext(), false); }

                                                           
/* structure */  

{leftBracesStracture}			{ return token(ProgramParserSym.LBRACE, yytext(), false); }
{rightBracesStracture}			{ return token(ProgramParserSym.RBRACE, yytext(), false); }
{semiStracture}					{ return token(ProgramParserSym.SEMI, yytext(), false); }
{comaStracture}					{ return token(ProgramParserSym.COMA, yytext(), false); }


/* comments */

{LineComment}             		{ /* ignore */ }         
"/*"                           	{ lastPos(); yybegin(TRADITIONAL_COMMENT); }     

                                                             
/* whitespace */

{WhiteSpace}                   	{ /* ignore */ }
}


<STRING> {
\"                             	{ yybegin(YYINITIAL); return token(ProgramParserSym.STRING_LITERAL, "STRING", string.toString(), true); }
{StringCharacter}+             	{ string.append(yytext()); }
"\\n"							{ string.append("\n"); }
"\\t"							{ string.append("\t"); }
"\\\""							{ string.append("\""); }
"\\\\"							{ string.append("\\"); }
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
<<EOF>>							{ return token(ProgramParserSym.EOF, yytext(), false); }
