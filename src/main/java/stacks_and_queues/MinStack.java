package stacks_and_queues;

public class MinStack {
    private int[] storage;
    private int[] minStorage;
    private static final int DEFAULT_CAPACITY = 12;
    private int currentSize;
    private int minSize;

    public MinStack() {
        this.storage = new int[DEFAULT_CAPACITY];
        this.currentSize = -1;
        this.minStorage = new int[DEFAULT_CAPACITY];
        this.minSize = -1;
    }

    public MinStack(int storageCapacity) {
        this.storage = new int[storageCapacity];
        this.currentSize = -1;
        this.minStorage = new int[storageCapacity];
        this.minSize = -1;
    }

    public int pop() {
        if(currentSize == -1) {
            throw new IllegalStateException("Cannot remove elements from an empty stack");
        }
        --this.minSize;
        return this.storage[this.currentSize--];
    }
    public int peek() {
        if(currentSize == -1) {
            throw new IllegalStateException("Cannot view top element on an empty stack");
        }
        return this.storage[this.currentSize];
    }
    public int push(int newData) {
        if(currentSize + 1 >= this.storage.length) {
            throw new IllegalStateException("Cannot add to a stack already at capacity");
        }
        if(this.minSize == -1 || newData <= this.minStorage[this.minSize]) {
            this.minStorage[++this.minSize] = newData;
        } else {
            this.minStorage[this.minSize+1] = this.minStorage[this.minSize];
            ++this.minSize;
        }
        this.storage[++this.currentSize] = newData;
        return newData;
    }
    public int min() {
        if(currentSize == -1) {
            throw new IllegalStateException("Cannot view minimum element on an empty stack");
        }
        return this.minStorage[this.minSize];
    }
}
