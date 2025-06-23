package com.example.leet_code_camp.Array.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                int j = map.get(complement);

                return (j < i) ? new int[]{j, i} : new int[]{i, j}; // ensure smaller index first
            }

            map.put(nums[i], i);
        }

        // Guaranteed to have a result
        return new int[]{-1, -1}; // fallback, shouldn't be reached
    }
}
