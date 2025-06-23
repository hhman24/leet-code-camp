package com.example.leet_code_camp.TowPointer.ValidPalindrome;

import java.util.Stack;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public boolean isPalindromeStack(String s) {
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }

        String str = cleaned.toString();
        int n = str.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n / 2; i++) {
            stack.push(str.charAt(i));
        }

        int start = (n % 2 == 0) ? (n / 2) : (n / 2) + 1;

        for (int i = start; i < n; i++) {
            if (stack.pop() != str.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
