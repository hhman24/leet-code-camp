package com.example.leet_code_camp.BinarySearch;

public class MinRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (right + left) / 2;  // prevents overflow

            if (nums[mid] > nums[right]) {
                // Min is in the right part
                left = mid + 1;
            } else {
                right = mid;  // Min is in the left part (including mid)
            }
        }

        return nums[left];
    }
}
