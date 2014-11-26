package ic.parser;

public class LexicalError extends Exception
{
	public LexicalError(int line, int column, String token) {
		super("Error!\t"+line+":"+" Lexical error: "+token);
    }
}

