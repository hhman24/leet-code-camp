package com.example.leet_code_camp.Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1; // should never happen if majority element is guaranteed
    }

    public int majorityElementVoting(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }

            count += (n == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
