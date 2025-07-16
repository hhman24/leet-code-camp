package com.example.leet_code_camp.Array;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;        // Pointer for nums1 (actual elements)
        int j = n - 1;        // Pointer for nums2
        int k = m + n - 1;    // Pointer for merged position in nums1

        // Merge nums2 into nums1 starting from the end
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If any remaining elements in nums2, copy them
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
