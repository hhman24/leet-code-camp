package com.example.leet_code_camp.Array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0; // slow pointer

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i; // new length
    }
}
