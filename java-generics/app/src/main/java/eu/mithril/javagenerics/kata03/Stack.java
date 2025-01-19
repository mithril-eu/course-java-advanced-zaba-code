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
        if (element == null) {
            throw new IllegalArgumentException("Cannot push null element");
        }
        if (isFull()) {
            throw new StackException("Stack is full");
        }
        elements[size++] = element;
    }

    /**
     * Pushes all elements from the collection onto the stack.
     *
     * @param elements collection of elements to push
     * @throws StackException if there isn't enough space
     */
    public void pushAll(Collection<? extends E> elements) {
        if (elements == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        if (size + elements.size() > capacity) {
            throw new StackException("Not enough space for all elements");
        }
        for (E element : elements) {
            push(element);
        }
    }

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element
     * @throws StackException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new StackException();
        }
        E element = (E) elements[--size];
        elements[size] = null;  // Help GC
        return element;
    }

    /**
     * Pops all elements from the stack into the destination collection.
     * Elements are popped in LIFO order.
     *
     * @param destination collection to receive the elements
     */
    public void popAll(Collection<? super E> destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination collection cannot be null");
        }
        while (!isEmpty()) {
            destination.add(pop());
        }
    }

    /**
     * Returns the top element without removing it.
     *
     * @return the top element
     * @throws StackException if the stack is empty
     */
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new StackException();
        }
        return (E) elements[size - 1];
    }

    /**
     * Removes all elements from the stack.
     */
    public void clear() {
        // Clear references to help GC
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
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