package com.example.leet_code_camp.SlidingWindow;

public class LongestSubStringRepeatingReplacement {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, right = 0;
        int maxFreq = 0; // max frequency of any single char in current window
        int maxLen = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowSize = right - left + 1;
            int replacementNeeded = windowSize - maxFreq;

            if (replacementNeeded > k) {
                // shrink window from the left
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}
