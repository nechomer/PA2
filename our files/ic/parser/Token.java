package ic.parser;
import java_cup.runtime.Symbol;

public class Token extends Symbol {
    public int line, column;
    public String tag
    public Object value;

    public Token(int id, int line, int column, String tag, Object value) {
    	super(id, value);
        this.line = line;
        this.column = column;
        this.tag = tag;
        this.value = value;
    }

    public Token(int id, int line, int column, String tag) {
    	super(id, null);
        this.line = line;
        this.column = column;
        this.tag = tag;
        this.value = value;
    }

    public String toString() {
		String val = value != null ? "(" + value + ")" : "";
		return name +  val;
	}
}

