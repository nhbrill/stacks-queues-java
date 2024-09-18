interface QueueInterface {

    /*
     * Add an element to the back of the queue.
     */
    void enqueue(int value);

    /*
     * Remove and return the front element in the queue.
     */
    int dequeue();

    /*
     * Return the front element of the queue.
     */
    int peek();

    /*
     * Returns true if the queue has no elements.
     */
    boolean isEmpty();

    /*
     * Returns the number of elements in the queue.
     */
    int size();

    /*
     * Removes all elements from the queue.
     */
    void clear();
}
