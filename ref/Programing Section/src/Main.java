import ic.ast.Node;
import ic.ast.PrettyPrint;
import ic.lexer.Lexer;
import ic.lexer.LexerException;
import ic.lexer.Token;
import ic.parser.Parser;
import ic.parser.ParserException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @team TheCunningLinguists <velbaumm@mail.tau.ac.il>
 * 1. Stanislav Podolsky
 * 2. Artyom Lukianov
 * 3. Michael Velbaum
 */

public class Main {

    public static void main(String[] args) {
        List<Token> tokens = new ArrayList<Token>();
        List<Token> libtokens = new ArrayList<Token>();
        
        try {
            // Lexical analysis
            Lexer.process(new FileReader(args[0]), tokens);
            if (args.length > 1) 
                Lexer.process(new FileReader(args[1].substring(2)), libtokens);
            
            // Syntax Analysis
            Node progAst = null, libAst = null;            
            progAst = Parser.processProgram(tokens);
            if (args.length > 1) 
                libAst = Parser.processLibrary(libtokens);
            
            // print library AST (if exists)
            if (libAst != null) 
                System.out.println(libAst.accept(new PrettyPrint()));
            
            // print program AST
            if (progAst != null) 
                System.out.println(progAst.accept(new PrettyPrint()));   
        } catch (LexerException | ParserException | IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
       
    }
}