package stacks_and_queues;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.*;

public class SortStackTest {

    private SortStack sortStack;
    private Stack<Integer> stack;


    @Before
    public void setUp() {
        stack = new Stack<>();
        stack.push(50);
        stack.push(40);
        stack.push(30);
        stack.push(20);
        sortStack = new SortStack(stack);
    }

    @Test
    public void shouldSortProperlyOnPush() {
        sortStack.push(70);
        assertEquals(new Integer(20), stack.peek());
    }

    @Test
    public void shouldPopCorrectNumber() {
        assertEquals(20, sortStack.pop());
    }

    @Test
    public void shouldPeekCorrectNumber() {
        assertEquals(20, sortStack.peek());
    }

    @Test
    public void shouldReturnTrueIfEmpty() {
        sortStack = new SortStack(new Stack<>());
        assertTrue(sortStack.isEmpty());
    }

    @Test
    public void shouldReturnFalseIfNotEmpty() {
        assertFalse(sortStack.isEmpty());
    }
}