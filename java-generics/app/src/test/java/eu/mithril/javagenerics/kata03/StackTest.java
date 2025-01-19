package eu.mithril.javagenerics.kata03;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Generic Stack Tests")
public class StackTest {

    @Test
    @DisplayName("Should push and pop elements correctly")
    void shouldPushAndPopElements() {
        Stack<String> stack = new Stack<>(3);

        stack.push("first");
        stack.push("second");
        stack.push("third");

        assertEquals("third", stack.pop());
        assertEquals("second", stack.pop());
        assertEquals("first", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Should handle peek operation correctly")
    void shouldHandlePeekOperation() {
        Stack<Integer> stack = new Stack<>(2);

        stack.push(1);
        assertEquals(1, stack.peek());
        stack.push(2);
        assertEquals(2, stack.peek());

        // Peek shouldn't remove the element
        assertEquals(2, stack.peek());
    }

    @Test
    @DisplayName("Should throw exception when popping empty stack")
    void shouldThrowExceptionOnEmptyPop() {
        Stack<Double> stack = new Stack<>(5);

        assertThrows(StackException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Should throw exception when peeking empty stack")
    void shouldThrowExceptionOnEmptyPeek() {
        Stack<Character> stack = new Stack<>(5);

        assertThrows(StackException.class, () -> stack.peek());
    }

    @Test
    @DisplayName("Should handle capacity correctly")
    void shouldHandleCapacity() {
        Stack<Integer> stack = new Stack<>(2);

        stack.push(1);
        stack.push(2);
        assertThrows(StackException.class, () -> stack.push(3));
        assertTrue(stack.isFull());
    }

    @Test
    @DisplayName("Should clear stack correctly")
    void shouldClearStack() {
        Stack<String> stack = new Stack<>(3);

        stack.push("a");
        stack.push("b");
        stack.clear();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Should handle multiple push and pop operations")
    void shouldHandleMultipleOperations() {
        Stack<Integer> stack = new Stack<>(5);

        stack.push(1);
        stack.push(2);
        assertEquals(2, stack.pop());
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    @DisplayName("Should push all elements from collection")
    void shouldPushAllFromCollection() {
        Stack<String> stack = new Stack<>(5);
        List<String> items = List.of("one", "two", "three");

        stack.pushAll(items);

        assertEquals("three", stack.pop());
        assertEquals("two", stack.pop());
        assertEquals("one", stack.pop());
    }

    @Test
    @DisplayName("Should pop all elements to collection")
    void shouldPopAllToCollection() {
        Stack<Integer> stack = new Stack<>(5);
        List<Integer> numbers = List.of(1, 2, 3);

        stack.pushAll(numbers);
        List<Number> destination = new ArrayList<>();
        stack.popAll(destination);

        assertEquals(3, destination.size());
        assertEquals(List.of(3, 2, 1), destination);
    }

    @Test
    @DisplayName("Should maintain type safety with inheritance")
    void shouldMaintainTypeSafety() {
        Stack<Number> stack = new Stack<>(5);

        stack.push(1);      // Integer
        stack.push(2.0);    // Double
        stack.push(3L);     // Long

        assertEquals(3L, stack.pop());
        assertEquals(2.0, stack.pop());
        assertEquals(1, stack.pop());
    }
}