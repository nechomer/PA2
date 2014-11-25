package ic.parser;
import java_cup.runtime.Symbol;

public class Token extends Symbol {
    public int line, column;
    public String tag, value;

    public Token(int id, int line, int column, String tag, String value) {
    	super(id, null);
        this.line = line;
        this.column = column;
        this.tag = tag;
        this.value = value;
    }
}

