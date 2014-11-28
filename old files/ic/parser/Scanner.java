package ic.parser;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

public class Scanner {

    public void process(Reader rd, Collection<Token> tokens)
            throws LexicalError, IOException {
        Lexer lexer = new Lexer(rd);
        Token token;
        while ((token = lexer.yylex()) != null)
            tokens.add(token);
    }

}