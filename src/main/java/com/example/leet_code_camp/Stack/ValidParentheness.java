package com.example.leet_code_camp.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheness {
    public boolean isValid(String s) {
//        if (s.length() % 2 != 0) return false; // odd length can't be valid
//
//        Stack<Character> stack = new Stack<>();

        if ((s.length() & 1) == 1) return false; // bitwise check for odd length

        Deque<Character> stack = new ArrayDeque<>();


        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }

        return stack.isEmpty();
    }
}
