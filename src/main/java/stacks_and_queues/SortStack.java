package stacks_and_queues;

import java.util.Stack;

public class SortStack{
    private Stack<Integer> storage;

    public SortStack() {
        storage = new Stack<>();
    }

    public SortStack(Stack<Integer> stack) {
        storage = stack;
    }

    public int peek() {
        return storage.peek();
    }

    public void push(int element) {
        Stack<Integer> tempStack = new Stack<>();
        while(!storage.isEmpty()){
            if(storage.peek() < element) {
                tempStack.push(storage.pop());
            }
        }
        storage.push(element);
        while(!tempStack.isEmpty()){
            storage.push(tempStack.pop());
        }
    }

    public int pop() {
        return storage.pop();
    }

    public boolean isEmpty() {
        return storage.isEmpty();
    }
}
