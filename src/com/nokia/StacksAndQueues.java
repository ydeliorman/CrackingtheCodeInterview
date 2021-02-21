package com.nokia;

import java.util.*;

class MyStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;

        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> t = new StackNode<T>(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class MyQueueOrg<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {
        QueueNode<T> t = new QueueNode<T>(item);
        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new NoSuchElementException();
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

class ThreeStack extends Stack<Integer> {
    Stack<Integer> stack = new Stack<>();

    public void push(int value) {
        if (value < stack.peek()) {
            stack.push(value);
        }
    }

    public Integer pop() {
        int value = pop();

        if (value == stack.peek()) {
            stack.pop();
        }
        return value;
    }
}

class SetOfStacks {
    List<Stack> stackList = new ArrayList<>();
    int capacity;

    public void push(int value) {
        Stack lastStack = getLastStack();
        if (lastStack.size() < capacity) {
            lastStack.push(value);
        } else {
            Stack stack = new Stack();
            stack.push(value);
            stackList.add(stack);
        }
    }

    public Object pop() {
        Stack lastStack = getLastStack();
        Object value = lastStack.pop();
        if (lastStack.size() == 0) {
            stackList.remove(stackList.size() - 1);
        }
        return value;
    }

    public Stack getLastStack() {
        return stackList.get(stackList.size() - 1);
    }
}

class MyQueue<T> {
    Stack<T> firstQueue = new Stack<>();
    Stack<T> secondQueue = new Stack<>();

    public int size() {
        return firstQueue.size() + secondQueue.size();
    }

    public void add(T value) {
        firstQueue.push(value);
    }

    public void shiftStack() {
        if (secondQueue.isEmpty()) {
            while (!firstQueue.isEmpty()) {
                secondQueue.push(firstQueue.pop());
            }
        }
    }

    public T peek() {
        shiftStack();
        return secondQueue.peek();
    }

    public T remove() {
        shiftStack();
        return secondQueue.pop();
    }
}

public class StacksAndQueues {
    public static void main(String[] args) {

    }

    public void sort(Stack<Integer> stack) {
        Stack<Integer> bufferStack = new Stack<>();

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();
            while(!bufferStack.isEmpty() && bufferStack.peek() > pop) {
                stack.push(bufferStack.pop());
            }
            bufferStack.push(pop);
        }

        while(!bufferStack.isEmpty()) {
            stack.push(bufferStack.pop());
        }
    }
}


