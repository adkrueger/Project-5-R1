import java.util.ArrayList;
import java.util.List;

public class CompoundExpressionImpl implements CompoundExpression {
    private String _contents;
    private List<Expression> _expressions = new ArrayList<>();

    CompoundExpressionImpl(String contents) {
        _contents = contents;
    }

    /**
     * Adds the specified expression as a child.
     *
     * @param subexpression the child expression to add
     */
    public void addSubexpression(Expression subexpression) {
        _expressions.add(subexpression);
    }

    /**
     * Returns the expression's parent.
     *
     * @return the expression's parent
     */
    public CompoundExpression getParent() {
        return null;
    }

    /**
     * Sets the parent be the specified expression.
     *
     * @param parent the CompoundExpression that should be the parent of the target object
     */
    public void setParent(CompoundExpression parent) {

    }

    /**
     * Creates and returns a deep copy of the expression.
     * The entire tree rooted at the target node is copied, i.e.,
     * the copied Expression is as deep as possible.
     *
     * @return the deep copy
     */
    public Expression deepCopy() {
        Expression expression = new CompoundExpressionImpl(this._contents);
        List<Expression> expressionsCopy = new ArrayList<>();

        for (Expression e : _expressions) {
            expressionsCopy.add(e);
        }

        return expression;
    }

    /**
     * Recursively flattens the expression as much as possible
     * throughout the entire tree. Specifically, in every multiplicative
     * or additive expression x whose first or last
     * child c is of the same type as x, the children of c will be added to x, and
     * c itself will be removed. This method modifies the expression itself.
     */
    public void flatten() {

    }

    /**
     * Creates a String representation by recursively printing out (using indentation) the
     * tree represented by this expression, starting at the specified indentation level.
     *
     * @param stringBuilder the StringBuilder to use for building the String representation
     * @param indentLevel   the indentation level (number of tabs from the left margin) at which to start
     */
    public void convertToString(StringBuilder stringBuilder, int indentLevel) {
        indent(stringBuilder, indentLevel);
        stringBuilder.append(_contents);
        stringBuilder.append("\n");
        int indentMod;               // modifies the number of indents. either 1 or 0
        int childCount = 0;          // represents the "index" number of the child in relation to the parent

        for (Expression n : _expressions) {
            childCount++;            // increases to represent the index of the child

            if (childCount == 1)     // if this child is the newest of a set, then increase indent by 1
                indentMod = 1;
            else                     // otherwise the indent level remains the same
                indentMod = 0;

            n.convertToString(stringBuilder, indentLevel += indentMod);   // recursive call to keep going down the list
        }
    }



    public String convertToString(int indentLevel) {
        final StringBuilder stringBuilder = new StringBuilder();
        convertToString(stringBuilder, indentLevel);
        return stringBuilder.toString();
    }

    /**
     * Static helper method to indent a specified number of times from the left margin, by
     * appending tab characters to the specified StringBuilder.
     *
     * @param stringBuilder the StringBuilder to which to append tab characters.
     * @param indentLevel   the number of tabs to append.
     */
    public static void indent(StringBuilder stringBuilder, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            stringBuilder.append('\t');
        }
    }
}
