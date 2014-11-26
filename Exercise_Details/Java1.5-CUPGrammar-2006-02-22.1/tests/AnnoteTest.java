@TestPackageAnnote package annotetest;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;

/* Test skeleton for java parser/lexer.
 * Copyright (C) 1998 C. Scott Ananian <cananian@alumni.princeton.edu>
 * This is released under the terms of the GPL with NO WARRANTY.
 * See the file COPYING for more details.
 */

public @interface TestAnnote0 { int value() default 1;}
@testtag public @interface TestAnnote1 { int value() default 1;}
public @testtag @interface TestAnnote2 { int value() default 1;}
@testtag public @testtag @interface TestAnnote3 { int value() default 1;}
@testtag @interface TestAnnote3 { int value() default 1;}

@TestMarker
@TestSingle(17)
public
@TestNormal(a=31, b= 88)
class AnnoteTest {
    @testtag public static int foo;

    public @testtag static AnnoteTest() {
    }

    public static @testtag void bar(@testtag String args[])  {
	@testtag int quux;
	final @testtag int foobar;
    }
    
    @testtag enum TestEnum {PASSED, @testtag FAILED, UNCERTAIN}
}

