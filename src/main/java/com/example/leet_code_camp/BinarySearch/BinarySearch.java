package com.example.leet_code_camp.BinarySearch;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;  // prevents overflow

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;  // eliminate mid
            } else {
                right = mid - 1; // eliminate mid
            }
        }

        return -1;
    }
}
