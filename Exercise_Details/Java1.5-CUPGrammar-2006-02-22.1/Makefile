# Makefile to create simple test framework for the java parsers.
# Copyright (C) 1998 C. Scott Ananian <cananian@alumni.princeton.edu>
# Released under the terms of the GPL with NO WARRANTY. See COPYING.

# Stripped-down and lightly tweaked by Jeremy Brown
# <jhbrown@alum.mit.edu> in Feb, 2006.  Thanks to javac's tendency to
# follow dependencies, this could be shrunk even more.

# java environment.
JAVA=java
JAVAC=javac
JFLAGS=-g
#CUPFLAGS=-dump_states

# List the target java grammar versions
JAVA_GRAMMAR=15

LEXER_FILES= \
	Lex/BooleanLiteral.java \
	Lex/CharacterLiteral.java \
	Lex/Comment.java \
	Lex/DocumentationComment.java \
	Lex/DoubleLiteral.java \
	Lex/EOF.java\
	Lex/EndOfLineComment.java \
	Lex/EscapedUnicodeReader.java \
	Lex/FIFO.java \
	Lex/FloatLiteral.java \
	Lex/Identifier.java \
	Lex/InputElement.java \
	Lex/IntegerLiteral.java \
	Lex/Keyword.java \
	Lex/Lexer.java \
	Lex/Literal.java \
	Lex/LongLiteral.java \
	Lex/NullLiteral.java \
	Lex/NumericLiteral.java \
	Lex/Operator.java \
	Lex/Separator.java \
	Lex/StringLiteral.java \
	Lex/Token.java \
	Lex/TraditionalComment.java \
	Lex/WhiteSpace.java

LEXER_CLASSES=${LEXER_FILES:.java=.class}

all: Parse/Grm.class Parse/Sym.class Main/Main.class ${LEXER_CLASSES}

# Feed the appropriate CUP specification to javaCUP.
Parse/Grm.java Parse/Sym.java: Parse/java${JAVA_GRAMMAR}.cup
	cd Parse && \
	${JAVA} java_cup.Main ${CUPFLAGS} -parser Grm -symbols Sym \
		< java${JAVA_GRAMMAR}.cup 

# Compile the java source for the parser.
Parse/Grm.class: Parse/Grm.java Parse/Sym.java 
	${JAVAC} ${JFLAGS} $^

# Compile the java source for the lexer.
${LEXER_CLASSES}: ${LEXER_FILES}
	${JAVAC} ${JFLAGS} ${LEXER_FILES}

# Compile the java source for the driver.
Main/Main.class: Main/Main.java
	${JAVAC} ${JFLAGS} Main/Main.java

# run some quick tests.
test: all 
	for f in tests/*.java Lex/*.java Parse/*.java; do \
		echo Parsing $$f...; \
		${JAVA} Main.Main $$f 5 || exit 1; \
	done

# target to make the distributed files.
dist:
	-$(RM) -rf JavaGrammar javagrm.tar.gz javagrm.zip
	cvs -d `cat CVS/Root` co -A -P JavaGrammar
	find JavaGrammar -type d -name CVS | xargs $(RM) -rf
	tar czvf javagrm.tar.gz JavaGrammar
	zip -r javagrm.zip JavaGrammar
	cp javagrm.tar.gz `date +javagrm-%d-%b-%Y.tar.gz`
	cp README javagrm-README.txt
	$(RM) -rf JavaGrammar

# clean up after ourselves.
clean:
	$(RM) Lex/*.class Parse/Sym.java Parse/Grm.java Parse/*.class \
              Main/*.class 
