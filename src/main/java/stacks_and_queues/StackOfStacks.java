package stacks_and_queues;

import java.util.ArrayList;
import java.util.Stack;

public class StackOfStacks {

    public ArrayList<Stack<Integer>> stackStorage;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int currentStack;

    public StackOfStacks() {
        this.stackStorage = new ArrayList<>();
        this.capacity = DEFAULT_CAPACITY;
        this.stackStorage.add(new Stack<>());
        this.currentStack = 0;
    }

    public StackOfStacks(int capacity) {
        this.stackStorage = new ArrayList<>();
        this.capacity = capacity;
        this.stackStorage.add(new Stack<>());
        this.currentStack = 0;
    }

    public int push(int newData) {
        Stack<Integer> stack;
        if(this.stackStorage.get(this.currentStack).size() == (this.capacity)) {
            if(this.stackStorage.size() <= this.currentStack+1) {
                this.stackStorage.add(new Stack<>());
            }
            stack = this.stackStorage.get(++this.currentStack);
        } else {
            stack = this.stackStorage.get(this.currentStack);
        }
        stack.push(newData);
        return newData;
    }

    public int pop() {
        if(this.stackStorage.get(this.currentStack).isEmpty()) {
            --this.currentStack;
        }
        return this.stackStorage.get(this.currentStack).pop();
    }

    public int peek() {
        return this.stackStorage.get(this.currentStack).peek();
    }

    public int popAt(int stackNum) {
        return this.stackStorage.get(stackNum-1).pop();
    }
}
