import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/*
 * Code to test Project 5; you should definitely add more tests!
 */
public class ExpressionParserPartialTester {
    private ExpressionParser _parser;

    @Before
    /*
     * Instantiates the parser
     */
    public void setUp() {
        _parser = new SimpleExpressionParser();
    }

    @Test
    /*
     * Just verifies that the SimpleExpressionParser could be instantiated without crashing.
     */
    public void finishedLoading() {
        assertTrue(true);
        // Yay! We didn't crash
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpression1() throws ExpressionParseException {
        final String expressionStr = "a+b";
        final String parseTreeStr = "+\n\ta\n\tb\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpression2() throws ExpressionParseException {
        final String expressionStr = "13*x";
        final String parseTreeStr = "*\n\t13\n\tx\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpression3() throws ExpressionParseException {
        final String expressionStr = "4*(z+5*x)";
        final String parseTreeStr = "*\n\t4\n\t()\n\t\t+\n\t\t\tz\n\t\t\t*\n\t\t\t\t5\n\t\t\t\tx\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpression4() throws ExpressionParseException {
        final String expressionStr = "(((((5)))))";
        final String parseTreeStr = "()\n\t()\n\t\t()\n\t\t\t()\n\t\t\t\t()\n\t\t\t\t\t5\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpressionAndFlatten1() throws ExpressionParseException {
        final String expressionStr = "1+2+3";
        final String parseTreeStr = "+\n\t1\n\t2\n\t3\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpressionAndFlatten2() throws ExpressionParseException {
        final String expressionStr = "(x+(x)+(x+x)+x)";
        final String parseTreeStr = "()\n\t+\n\t\tx\n\t\t()\n\t\t\tx\n\t\t()\n\t\t\t+\n\t\t\t\tx\n\t\t\t\tx\n\t\tx\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpressionAndFlatten3() throws ExpressionParseException {
        final String expressionStr = "5+5+5+5+5+5+5+5+5";
        final String parseTreeStr = "+\n\t5\n\t5\n\t5\n\t5\n\t5\n\t5\n\t5\n\t5\n\t5\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testExpressionAndFlatten4() throws ExpressionParseException {
        final String expressionStr = "5+(5+j)+5+x+5+5*609*98765";
        final String parseTreeStr = "+\n\t5\n\t()\n\t\t+\n\t\t\t5\n\t\t\tj\n\t5\n\tx\n\t5\n\t*\n\t\t5\n\t\t609\n\t\t98765\n";
        assertEquals(parseTreeStr, _parser.parse(expressionStr, false).convertToString(0));
    }

    @Test(expected = ExpressionParseException.class)
    /*
     * Verifies that a specific expression throws the ExpressionParseException
     */
    public void testException1() throws ExpressionParseException {
        final String expressionStr = "1+2+";
        _parser.parse(expressionStr, false);
    }

    @Test(expected = ExpressionParseException.class)
    /*
     * Verifies that a specific expression is parsed into the correct parse tree.
     */
    public void testException2() throws ExpressionParseException {
        final String expressionStr = "((()))";
        _parser.parse(expressionStr, false);
    }

    @Test(expected = ExpressionParseException.class)
    /*
     * Verifies that a specific expression throws the ExpressionParseException
     */
    public void testException3() throws ExpressionParseException {
        final String expressionStr = "()()";
        _parser.parse(expressionStr, false);
    }

    @Test(expected = ExpressionParseException.class)
    /*
     * Verifies that a specific expression throws the ExpressionParseException
     */
    public void testException4() throws ExpressionParseException {
        final String expressionStr = "+*";
        _parser.parse(expressionStr, false);
    }

    @Test(expected = ExpressionParseException.class)
    /*
     * Verifies that a specific expression throws the ExpressionParseException
     */
    public void testException5() throws ExpressionParseException {
        final String expressionStr = "";
        _parser.parse(expressionStr, false);
    }

    @Test(expected = ExpressionParseException.class)
    /*
     * Verifies that a specific expression throws the ExpressionParseException
     */
    public void testException6() throws ExpressionParseException {
        final String expressionStr = "((((((()6";
        _parser.parse(expressionStr, false);
    }
}
