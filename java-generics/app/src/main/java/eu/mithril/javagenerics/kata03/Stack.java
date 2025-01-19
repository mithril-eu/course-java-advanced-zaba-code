package eu.mithril.javagenerics.kata03;


import java.util.Collection;

/**
 * A generic stack implementation with bounded capacity.
 *
 * @param <E> the type of elements in the stack
 */
public class Stack<E> {

    private Object[] elements;
    private int size;
    private final int capacity;

    public Stack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.size = 0;
    }

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param element the element to push
     * @throws StackException if the stack is full
     */
    public void push(E element) {
        return; // TODO: Implement this method
    }

    /**
     * Pushes all elements from the collection onto the stack.
     *
     * @param elements collection of elements to push
     * @throws StackException if there isn't enough space
     */
    public void pushAll(Collection<? extends E> elements) {
        return; // TODO: Implement this method
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element
     * @throws StackException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        return null; // TODO: Implement this method
    }

    /**
     * Pops all elements from the stack into the destination collection.
     * Elements are popped in LIFO order.
     *
     * @param destination collection to receive the elements
     */
    public void popAll(Collection<? super E> destination) {
        return; // TODO: Implement this method
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws StackException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        return null; // TODO: Implement this method
    }

    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        return; // TODO: Implement this method
    }

    /**
     * Returns the current number of elements in the stack.
     *
     * @return the size of the stack
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the stack is full.
     *
     * @return true if the stack is full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
    }
}