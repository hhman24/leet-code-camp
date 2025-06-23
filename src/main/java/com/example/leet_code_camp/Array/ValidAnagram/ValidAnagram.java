package com.example.leet_code_camp.Array.ValidAnagram;


import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> countMap = new HashMap<>();

        if (s == null || t == null || s.length() != t.length()) return false;

        // Convert strings to char arrays
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            countMap.put(cs, countMap.getOrDefault(cs, 0) + 1);
            countMap.put(ct, countMap.getOrDefault(ct, 0) - 1);
        }

        for (int count : countMap.values()) {
            if (count != 0) return false;
        }


        return true;
    }

    public static void main(String[] args) {

    }
}
