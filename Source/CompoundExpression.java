interface CompoundExpression extends Expression {
    /**
     * Adds the specified expression as a child.
     *
     * @param subexpression the child expression to add
     */
    void addSubexpression(Expression subexpression);


    /**
     * Static helper method to indent a specified number of times from the left margin, by
     * appending tab characters to the specified StringBuilder.
     *
     * @param stringBuilder the StringBuilder to which to append tab characters.
     * @param indentLevel   the number of tabs to append.
     */
    void indent(StringBuilder stringBuilder, int indentLevel);

    /**
     * Creates and returns a deep copy of the expression.
     * The entire tree rooted at the target node is copied, i.e.,
     * the copied Expression is as deep as possible.
     *
     * @return the deep copy
     */
    Expression deepCopy();
}
