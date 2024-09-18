/*
* AUTHOR: Nate Brill
* FILE: ArrayStack.java
* PURPOSE: To implement a stack backed by an array.
*/
public class ArrayStack implements StackInterface {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int index;
    private int size;

    public ArrayStack() {
        /*
         * PURPOSE: To initialize an ArraySatck by creating an array and
         * setting it's default size to 10 as well as setting the size or
         * capacity to 10, and the index to zero because the list is empty.
         */
        array = new int[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;
        this.index = 0;
    }

    public ArrayStack(int[] arrayO, int indexO, int sizeO) {
        /*
         * PURPOSE: To initialize an ArrayStack by creating an array and
         * setting its values to another array for copying arrays.
         */
        this.array = arrayO;
        this.index = indexO;
        this.size = sizeO;
    }

    @Override
    public void push(int value) {
        /*
         * PURPOSE: To add to the ArrayStack, first by making sure the array is
         * long enough to be changed at the current index and then setting the
         * end of the array representing the top of the stack to the passed in
         * value and incrementing the index by one.
         * 
         * @param value, an int value that someone is adding to the ArrayStack.
         */
        if (this.index == size) {
            this.growArray();
        }
        this.array[index] = value;
        this.index++;
    }

    @Override
    public int pop() {
        /*
         * PURPOSE: To remove a value from the ArrayStack, if the array is
         * empty then the method returns -1, otherwise it removes the front
         * element and decreases the index by 1 returning the value removed.
         * 
         * @return value, the value removed from the array.
         */
        if (this.size == 0) {
            return -1;
        } else {
            int value = this.array[index - 1];
            index--;
            return value;
        }
    }

    @Override
    public int peek() {
        /*
         * PURPOSE: To return the first value in the Queue.
         * 
         * @Return int, the value at the index in the array.
         */
        return this.array[index - 1];
    }

    @Override
    public boolean isEmpty() {
        /*
         * PURPOSE: Determines if the array is empty.
         * 
         * @return boolean, returns true if the array is empty and false if the
         * array is not empty.
         */
        if (this.size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        /*
         * PURPOSE: Returns the size of the Stack.
         * 
         * @return index, returns index because that is the last index of the
         * elements added to the array.
         */
        return this.index;
    }

    @Override
    public void clear() {
        /*
         * PURPOSE: To clear the array by setting the index to 0, that makes
         * sure the methods only edit values in from that index making the
         * array empty.
         */
        this.index = 0;
    }

    public void growArray() {
        /*
         * PURPOSE: growArray() grows the array if the capacity or size of the
         * array is less then the values trying to be added so more memory
         * needs to be allocated so the 10, the default capacity is added to
         * the current capacity.
         */
        int[] newArray = new int[this.size + DEFAULT_CAPACITY];
        for (int i = 0; i < this.index; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.size += DEFAULT_CAPACITY;
    }

    public ArrayStack copy() {
        /*
         * PURPOSE: Copies an ArrayStack to another ArrayStack by iterating
         * through all the values and putting them in a new ArrayStack.
         * 
         * @return newStack, a new ArrayStack with all the same elements.
         */
        ArrayStack newStack = new ArrayStack(this.array, this.index, this.size);
        return newStack;
    }

    @Override
    public String toString() {
        /*
         * PURPOSE: To create a string representation of the array.
         * 
         * @return stringS, the string representation of the array.
         */
        String stringS = "{ ";
        for (int i = this.index - 1; i >= 0; i--) {
            stringS += Integer.toString(this.array[i]) + ", ";
        }
        stringS += "}";
        return stringS;
    }

    @Override
    public boolean equals(Object o) {
        /*
         * PURPOSE: Determines whether an object is an ArrayStack and then
         * whether the size is the same, as well as all the values in the
         * array are equivalent.
         * 
         * @param o, an object.
         * 
         * @return boolean, if the object is equal return true if not return
         * false.
         */
        if (!(o instanceof ArrayStack)) { // If the object is an ArrayStack.
            return false;
        }
        ArrayStack other = (ArrayStack) o;
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
