

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ic.parser.Lexer;
import ic.parser.LexicalError;
import ic.parser.Token;

public class Main
{
	public static void main(String[] args) {
        Token token;
        //debug(args[0]);
        PrintHeader();
        try {
            Lexer lexer = new Lexer(new FileReader(args[0]));
            while ((token = lexer.yylex()) != null)
            	PrintToken(token.value,
                        token.tag, token.line, token.column);

        } catch (IOException e) {
            System.err.printf("IO Error:\n%s\n", e.getMessage());
        } catch (LexicalError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
	
	public static void PrintHeader() { 
		System.out.println("token\ttag\tline :column");
	}
	
	public static void PrintToken(String token, String tag , int line , int column) {
		System.out. println (token+"\t"+tag+"\t"+line+":"+column); 
	}
	public static void PrintTokenError(String errMsg) {
		System.err. println ("Error!\t"+errMsg);
	}
	
	public static void debug(String path) {
		FileReader fr;
		try {
			 fr = new FileReader(path);
			char[] cbuf = new char[1];
			for (int i=0;i<10;i++) {
				fr.read(cbuf);
				System.out.println(cbuf[0]);
			}
			
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}