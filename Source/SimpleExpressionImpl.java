public class SimpleExpressionImpl implements Expression {

    private String _contents;

    /**
     * constructor that takes the contents of the expression
     * as a String
     *
     * @param contents the contents as a String
     */
    SimpleExpressionImpl(String contents) {
        _contents = contents;
    }

    /**
     * @return the contents
     */
    public String getContents() {
        return _contents;
    }


    /**
     * Creates and returns a deep copy of the expression.
     * The entire tree rooted at the target node is copied, i.e.,
     * the copied Expression is as deep as possible.
     *
     * @return the deep copy
     */
    public Expression deepCopy() {
        return new SimpleExpressionImpl(_contents);
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
    }

    /**
     * Helper function to call convertToString
     *
     * @param indentLevel the initial level of indentation
     * @return the properly formatted string
     */
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
    private static void indent(StringBuilder stringBuilder, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            stringBuilder.append('\t');
        }
    }
}
