/*
* AUTHOR: Nate Brill
* FILE: ArrayQueue.java
* PURPOSE: To implement a queue backed by an array.
*/
public class ArrayQueue implements QueueInterface {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int capacity;
    private int index;
    private int size;

    public ArrayQueue() {
        /*
         * PURPOSE: To initialize an ArrayQueue by creating an array and
         * setting it's default size to 10 as well as setting the size or
         * capacity to 10, and the index to zero because the list is empty.
         */
        array = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.index = 0;
        this.size = 0;
    }

    public ArrayQueue(int[] arrayO, int capacityO, int indexO, int sizeO) {
        this.array = arrayO;
        this.capacity = capacityO;
        this.index = indexO;
        this.size = sizeO;
        /*
         * PURPOSE: To initialize an ArrayQueue by creating an array and
         * setting its values to another array for copying arrays.
         */
    }

    @Override
    public void enqueue(int value) {
        /*
         * PURPOSE: To add to the ArrayQueue, first by making sure the array is
         * long enough to be changed at the current index and then changes the
         * index in the array to the value passed in, finally adding one to the
         * index. Adds the index to the end of the array.
         * 
         * @param value, an int value that someone is adding to the ArrayQueue.
         */
        this.size++;
        if (this.index == capacity) {
            this.growArray();
        }
        this.array[index] = value;
        this.index++;
    }

    @Override
    public int dequeue() {
        /*
         * PURPOSE: To remove a value from the ArrayQueue, if the array is
         * empty then the method returns -1, otherwise it removes the first
         * element and sets it to zero.
         * 
         * @return value, the value removed from the array.
         */
        this.size--;
        if (this.index == 0) {
            return -1;
        } else {
            int value = this.array[index - 1];
            this.array[index - 1] = 0;
            index--;
            return value;
        }
    }

    @Override
    public int peek() {
        /*
         * PURPOSE: To return the first value in the Queue.
         * 
         * @Return int, the value at the 0 index in the array.
         */
        if (this.index == 0) {
            return -1;
        } else {
            return this.array[0];
        }
    }

    @Override
    public boolean isEmpty() {
        /*
         * PURPOSE: Determines if the array is empty.
         * 
         * @return boolean, returns true if the array is empty and false if the
         * array is not empty.
         */
        if (this.index == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        /*
         * PURPOSE: Returns the size of the Queue.
         * 
         * @return index, returns index because that is the last index of the
         * elements added to the array.
         */
        return this.size;
    }

    @Override
    public void clear() {
        /*
         * PURPOSE: To clear the array by setting the index to 0, that makes
         * sure the methods only edit values in from that index making the
         * array empty.
         */
        this.index = 0;
        this.size = 0;
    }

    public void growArray() {
        /*
         * PURPOSE: growArray() grows the array if the capacity or size of the
         * array is less then the values trying to be added so more memory
         * needs to be allocated so the 10, the default capacity is added to
         * the current capacity.
         */
        int[] newArray = new int[this.capacity + DEFAULT_CAPACITY];
        for (int i = 0; i < this.index; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.capacity += DEFAULT_CAPACITY;
    }

    public ArrayQueue copy() {
        /*
         * PURPOSE: Copies an ArrayQueue to another ArrayQueue by iterating
         * through all the values and putting them in a new ArrayQueue.
         * 
         * @return newQueue, a new ArrayQueue with all the same elements.
         */
        ArrayQueue newQueue = new ArrayQueue(this.array, this.capacity,
                this.index, this.size);
        return newQueue;
    }

    @Override
    public String toString() {
        /*
         * PURPOSE: To create a string representation of the array.
         * 
         * @return stringQ, the string representation of the array.
         */
        String stringQ = "{ ";
        for (int i = 0; i < this.index; i++) {
            stringQ += Integer.toString(this.array[i]) + ", ";
        }
        stringQ += "}";
        return stringQ;
    }

    @Override
    public boolean equals(Object o) {
        /*
         * PURPOSE: Determines whether an object is an ArrayQueue and then
         * whether the size is the same, as well as all the values in the
         * array are equivalent.
         * 
         * @param o, an object.
         * 
         * @return boolean, if the object is equal return true if not return
         * false.
         */
        if (!(o instanceof ArrayQueue)) { // If the object is an ArrayQueue.
            return false;
        }
        ArrayQueue other = (ArrayQueue) o;
        if (this.size() == other.size()) { // If the object has the same size.
            for (int i = 0; i < this.size(); i++) {
                // If the object has the same element at the same position.
                if (this.array[i] != other.array[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
