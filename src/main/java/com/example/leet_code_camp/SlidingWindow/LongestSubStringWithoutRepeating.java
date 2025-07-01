package com.example.leet_code_camp.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, right = 0;
        int maxLength = 0;


        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // If duplicate, move left pointer and shrink window
            while (window.contains(currentChar)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
