package com.example.leet_code_camp.Stack;


import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private final List<Integer> stack;
    private final List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {

        stack.add(val);

        if (minStack.isEmpty()) {
            minStack.add(val);
        } else {
            int currentMin = minStack.getLast();
            minStack.add(Math.min(val, currentMin));
        }
    }

    public void pop() {
        stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}
