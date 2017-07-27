package stacks_and_queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    private MinStack minStack;

    @Before
    public void setUp() {
        minStack = new MinStack();
        minStack.push(10);
        minStack.push(12);
        minStack.push(5);
        minStack.push(11);
        minStack.push(6);
        minStack.push(9);
    }

    @Test
    public void shouldReturnMinimumValueWithNoValuesRemoved() {
        assertEquals(5, minStack.min());
    }

    @Test
    public void shouldReturnMinimumValueWithPopMethodUsage() {
        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();
        assertEquals(10, minStack.min());
    }
}