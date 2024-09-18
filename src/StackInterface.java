interface StackInterface {

    /*
     * Add an element to the top of the stack.
     */
    void push(int value);

    /*
     * Remove and return the top element in the stack.
     */
    int pop();

    /*
     * Return the top element of the stack.
     */
    int peek();

    /*
     * Returns true if the stack has no elements.
     */
    boolean isEmpty();

    /*
     * Returns the number of elements in the stack.
     */
    int size();

    /*
     * Removes all elements from the stack.
     */
    void clear();

}
