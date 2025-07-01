package com.example.leet_code_camp.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            s1Count[c - 'a']++;
        }

        // First window in s2
        for (int i = 0; i < s1.length(); i++) {
            windowCount[s2.charAt(i) - 'a']++;
        }

        // Check if first window matches
        if (Arrays.equals(s1Count, windowCount)) return true;

        // Slide the window through s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Add new character to window
            windowCount[s2.charAt(i) - 'a']++;
            // Remove the leftmost character from the window
            windowCount[s2.charAt(i - s1.length()) - 'a']--;

            if (Arrays.equals(s1Count, windowCount)) return true;
        }

        return false;
    }
}
