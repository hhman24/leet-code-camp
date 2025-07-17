package com.example.leet_code_camp.Array;

public class FindIndexOfTheFirstOccurrence {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int hayLen = haystack.length();
        int needleLen = needle.length();

        for (int j = 0; j <= hayLen - needleLen; j++) {
            if (haystack.charAt(j) == needle.charAt(0)) {
                boolean isValid = true;

                for (int i = 1; i < needleLen; i++) {
                    if (haystack.charAt(j + i) != needle.charAt(i)) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) return j;
            }
        }

        return -1;
    }

    // Best Performance: KMP Algorithm (Knuth-Morris-Pratt)
    // "sadbutsad"
    // "sad"
    public int strStrKMP(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int[] lps = computeLPS(needle);
        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
               i++;
               j++;

               if (j == needle.length()) {
                   return i - j; // found
               }
            }
            else {
                if (j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i++;
                }
            }
        }


        return -1;
    }

    // "ababaca"
    // i: 1, length: 0 -> mismatch -> len=0, lps[1]=0
    // i: 2, length: 0 -> match -> len=1, lps[2]=1
    // i: 3, length: 1 -> match -> len=1, lps[2]=1
    private int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            }
            else {
                if (length != 0) {
                    length = lps[length - 1];
                }
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
