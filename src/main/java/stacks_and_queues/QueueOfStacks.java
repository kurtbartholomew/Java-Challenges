package stacks_and_queues;

import java.util.Stack;

public class QueueOfStacks {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public QueueOfStacks() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public QueueOfStacks(Stack<Integer> inStack,Stack<Integer> outStack) {
        this.inStack = inStack;
        this.outStack = outStack;
    }

    public int enqueue(int data) {
        loadOutStack();
        inStack.push(data);
        return data;
    }

    public int dequeue() {
        loadOutStack();
        if(outStack.isEmpty()) { throw new IllegalStateException("Unable to dequeue an empty stack"); }
        return outStack.pop();
    }

    public int peek() {
        loadOutStack();
        if(outStack.isEmpty()) {
            throw new IllegalStateException("Unable to peek an empty queue");
        }
        return outStack.peek();
    }

    private void loadOutStack() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}
