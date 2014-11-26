package ic.parser;
import ic.parser.LexicalError;
/*********** Definitions ***********/
%%
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
	private Token token(int id, String tag, String value, boolean flag) {
		if(flag)
			return new Token(id,lLine,lCol,tag,value);
		else
			return new Token(id,getCurrentLine(),getCurrentColumn(),tag,value);
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


Operator = ("[" | "]" | "(" | ")" | "." | "-" | "!" | "*" | "/" | "%" | "+" |
            "<" | "<=" | ">" | ">=" | "==" | "!=" | "&&" | "||" | "=")

// StringCharacter:  ASCII codes incl 32 - 126 + " and \ + escape sequence: \", \\, \t, \n
StringCharacter = ([\040-\041\043-\133\135-\176] | "\\\"" | "\\\\" | "\\t" | "\\n")

Structure = [{};,]

%state STRING, TRADITIONAL_COMMENT

%%

/********* Rules and Actions **********/

<YYINITIAL> {
/* keywords */
classKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
extendsKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
staticKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); } 
voidKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
intKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
booleanKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
stringKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
returnKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
ifKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
elseKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
whileKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
breakKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
continueKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
thisKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
newKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
lengthKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
trueKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
falseKeyword					{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
nullKeyword						{ return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }


/* identifiers */
"_" {IdentifierCharacter}*     { Error(yytext(), false);}
{RegularIdentifier}            { return token(sym.ID,"ID", yytext(), false); }
{ClassIdentifier}              { return token(sym.CLASS_ID, "CLASS_ID", yytext(), false); }

/* literals */
0+ {DecIntegerLiteral}         { Error(yytext(), false); }
{DecIntegerLiteral}            { return token(sym.INTEGER, "INTEGER", yytext(), false); }
\"                             { lastPos(); string.setLength(0); string.append("\""); yybegin(STRING); }

/* operators */                                                 
{Operator}                     { return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
                                                                
/* structure */  
{Structure}                    { return token(sym.OTHER_SYMBOL, yytext(), yytext(), false); }
                                                                
/* comments */                                 
{LineComment}             		   { /* ignore */ }         
"/*"                           { lastPos(); yybegin(TRADITIONAL_COMMENT); }     
                                                                
/* whitespace */                                                
{WhiteSpace}                   { /* ignore */ }
}

<STRING> {
\"                             { yybegin(YYINITIAL); string.append("\""); return token(sym.STRING, "STRING", string.toString(), true); }
{StringCharacter}+             { string.append(yytext()); }
<<EOF>>                        { Error(yytext(), true); }
}

<TRADITIONAL_COMMENT> {
[^\*]                          { /* ignore */ }
"*/"                           { yybegin(YYINITIAL); }
"*"                            { /* ignore */ }
<<EOF>>                        { Error(yytext(), true); }
}

/* error fallback */
[^]                           { Error(yytext(), false); }

