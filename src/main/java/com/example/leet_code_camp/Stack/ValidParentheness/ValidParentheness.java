package com.example.leet_code_camp.Stack.ValidParentheness;

import java.util.Stack;

public class ValidParentheness {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            }

            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                char open = stack.pop();
                if (s.charAt(i) != open) {
                    return false;
                }
            }


        }

        return true;
    }
}
