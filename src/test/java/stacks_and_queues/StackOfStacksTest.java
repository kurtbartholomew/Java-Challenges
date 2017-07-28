package stacks_and_queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackOfStacksTest {

    private StackOfStacks stack;

    @Before
    public void setUp() {
        stack = new StackOfStacks(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
    }

    @Test
    public void shouldContainTheCorrectNumberOfStacks() {
        assertEquals(4,stack.stackStorage.size());
    }

    @Test
    public void shouldReturnTheCorrectNumberWhenUsingPeek() {
        assertEquals(10,stack.peek());
    }

    @Test
    public void shouldPopTheCorrectNumberUsingPopAt() {
        assertEquals(6,stack.popAt(2));
    }
}