import java.util.function.*;

/**
 * Starter code to implement an ExpressionParser. Your parser methods should use the following grammar:
 * E := A | X
 * A := A+M | M
 * M := M*M | X
 * X := (E) | L
 * L := [0-9]+ | [a-z]
 */
public class SimpleExpressionParser implements ExpressionParser {
	/**
	 * Attempts to create an expression tree -- flattened as much as possible -- from the specified String.
     * Throws a ExpressionParseException if the specified string cannot be parsed.
	 * @param str the string to parse into an expression tree
	 * @param withJavaFXControls you can just ignore this variable for R1
	 * @return the Expression object representing the parsed expression tree
	 */
	public Expression parse (String str, boolean withJavaFXControls) throws ExpressionParseException {
		// Remove spaces -- this simplifies the parsing logic
		str = str.replaceAll(" ", "");
		Expression expression = parseExpression(str);
		if (expression == null) {
			// If we couldn't parse the string, then raise an error
			throw new ExpressionParseException("Cannot parse expression: " + str);
		}

		// Flatten the expression before returning
		expression.flatten();
		return expression;
	}
	
	private Expression parseExpression(String str) {
		Expression expression;

		try {
		    expression = parse(str, false);
            return expression;
		}
		catch(ExpressionParseException e) {
		    e.printStackTrace();
		    return null;
        }
	}

    private static Expression parseHelper(String str, char op, Function<String, Expression> m1,
                                          Function<String, Expression> m2) {
        for (int i = 1; i < str.length() - 1; i++) {
            Expression m1Exp = m1.apply(str.substring(0, i));
            Expression m2Exp = m2.apply(str.substring(i+1));
            if (str.charAt(i) == op && m1Exp != null && m2Exp != null){
                /** TODO implement creation of nodes
                 *  Top of node should be the op
                 *  Children should be m1 and m2
                 */

                CompoundExpressionImpl opExpr = new CompoundExpressionImpl(Character.toString(op));
                opExpr.addSubexpression(m1Exp);
                opExpr.addSubexpression(m2Exp);
                return opExpr;
            }
        }
        return null;
    }

    private static Expression parseE (String str) {
        // A or X
        Expression A = parseA(str);
        if (A != null) {
            return A;
        }
        Expression E = parseE(str);
        if (E != null) {
            return E;
        }
        return null;
    }

    private static Expression parseM(String str) {
        // M * M or X
        Expression exp = parseHelper(str, '*', SimpleExpressionParser::parseM, SimpleExpressionParser::parseM);
        if (exp != null) {
            return exp;
        }
        Expression X = parseX(str);
        if(X != null) {
            return X;
        }
        return null;
    }

    private static Expression parseA (String str) {
        // A + M or M
        Expression exp = parseHelper(str, '+', SimpleExpressionParser::parseA, SimpleExpressionParser::parseM);
        if (exp != null) {
            return exp;
        }
        return null;
    }

    private static Expression parseX (String str) {
        // (E) or L
        Expression middleE = parseE(str.substring(1, str.length() - 1));
        if (str.length() >= 2 && str.charAt(0) == '(' && str.charAt(str.length()-1)
                == ')' &&  middleE  != null) {
            return middleE;
        }
        Expression L = parseL(str);
        if(L != null) {
            return L;
        }
        return null;
    }

    private static Expression parseL (String str) {
        if(str.matches("[a-z]|[0-9]+")) {
            //TODO: create new expression to return;
            return null;
        }
        return null;
    }

}
