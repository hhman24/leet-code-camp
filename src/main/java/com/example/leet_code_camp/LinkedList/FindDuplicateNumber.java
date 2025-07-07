package com.example.leet_code_camp.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) return num;
        }

        return -1;
    }

    /*
    * Linked List cycle detection.
    * Idea:
    * Treat each number as a pointer: nums[i] points to the next index.
    * Since there's a duplicate, we get a cycle.
    * Use the Floyd's algorithm to detect the cycle and find the entrance = duplicate.
     * */
    public int FloydTortoiseHare(int[] nums) {
        // Phase 1: Find the intersection point of the two runners
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
