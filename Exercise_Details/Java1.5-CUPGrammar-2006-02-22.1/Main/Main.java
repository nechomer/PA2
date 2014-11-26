package Main;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;

/* Test skeleton for java parser/lexer.
 * Copyright (C) 1998 C. Scott Ananian <cananian@alumni.princeton.edu>
 * This is released under the terms of the GPL with NO WARRANTY.
 * See the file COPYING for more details.
 */

public class Main {
  public static void main(String args[]) throws Exception {
    Reader fr = new BufferedReader(new FileReader(args[0]));
    // the integer in the next line specifies the java minor version.
    // for example, for a java 1.0 lexer specify '0'
    //              for a java 1.1 lexer specify '1'
    //              etc.
    // As far as the lexer's concerned, 'strictfp' was added in Java 1.2,
    // 'assert' in Java 1.4, and we used to need a "lookahead <" token PLT
    // to correctly parse Java 1.5. (but that was fixed.)
    int java_minor_version = 5;
    if (args.length>1) java_minor_version = Integer.parseInt(args[1]);
    Lex.Lexer l = new Lex.Lexer(fr, java_minor_version);
    java_cup.runtime.lr_parser g;
    switch (java_minor_version) {
    case 5: g = new Parse.Grm(l); break;
    default:
	throw new Exception("I only know about java 1.5 now.");
    }
    g./*debug_*/parse();
    System.exit(l.numErrors());
  }
}
