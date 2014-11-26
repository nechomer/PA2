package ic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java_cup.runtime.Symbol;
import ic.ast.ASTNode;
import ic.parser.Lexer;
import ic.parser.LexicalError;
import ic.parser.LibraryParser;
import ic.parser.ParserException;
import ic.parser.Scanner;
import ic.parser.Token;

public class Main
{
	public static void main(String[] args) {
        List<Token> tokens = new ArrayList<Token>();
        List<Token> libtokens = new ArrayList<Token>();
        
        try {
//            // Lexical analysis
//        	Scanner.process(new FileReader(args[0]), tokens);
//            if (args.length > 1) 
//            	Scanner.process(new FileReader(args[1].substring(2)), libtokens);
        	
//        	Token token;
//        	Object objValue;
//        	Lexer lexer = new Lexer(new FileReader(args[0]));
//        	while ((token = lexer.next_token()) != null) {
//            	objValue = token.value;
//            	System.out.println((objValue != null ? objValue.toString(): token.tag)+"\t"+token.tag+"\t"+token.line+":"+token.column+"\n");
//            }
//        	System.out.println("finished!");
            LibraryParser lp = new LibraryParser(new Lexer(new FileReader(args[0])));
            System.out.println("finished part 1!");
            Symbol result = lp.parse();
            System.out.println("finished part 2!");
            Object symbol = result.value;
            System.out.println("finished part 3!");
            
//            // Syntax Analysis
//            ASTNode progAst = null, libAst = null;            
//            progAst = parser.processProgram(tokens);
//            if (args.length > 1) 
//                libAst = parser.processLibrary(libtokens);
            
//            // print library AST (if exists)
//            if (libAst != null) 
//                System.out.println(libAst.accept(new PrettyPrint()));
//            
//            // print program AST
//            if (progAst != null) 
//                System.out.println(progAst.accept(new PrettyPrint()));
            
        } catch (ParserException  | LexicalError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (IOException e) {
            System.err.printf("IO Error:\n%s\n", e.getMessage());
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
}