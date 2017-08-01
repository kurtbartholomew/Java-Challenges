package stacks_and_queues;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Stack;

import static org.junit.Assert.*;

public class QueueOfStacksTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private QueueOfStacks queueOfStacks;
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    @Before
    public void setUp() {
        inStack = new Stack<>();
        outStack = new Stack<>();
        inStack.push(10);
        inStack.push(30);
        inStack.push(50);
        queueOfStacks = new QueueOfStacks(inStack, outStack);
    }

    @Test
    public void shouldEnqueueCorrectly() {
        queueOfStacks.enqueue(70);
        assertEquals(new Integer(70), inStack.peek());
    }

    @Test
    public void shouldDequeueCorrectly() {
        queueOfStacks.dequeue();
        assertEquals(30, queueOfStacks.dequeue());
    }

    @Test
    public void shouldPeekCorrectly() {
        assertEquals(10, queueOfStacks.peek());
    }

    @Test
    public void shouldThrowExceptionOnDequeueingEmptyStack() {
        exception.expect(IllegalStateException.class);
        queueOfStacks.dequeue();
        queueOfStacks.dequeue();
        queueOfStacks.dequeue();
        queueOfStacks.dequeue();
    }
    @Test
    public void shouldThrowExceptionOnPeekingEmptyStack() {
        exception.expect(IllegalStateException.class);
        queueOfStacks.dequeue();
        queueOfStacks.dequeue();
        queueOfStacks.dequeue();
        queueOfStacks.peek();
    }
}