package com.example.leet_code_camp.Array.ContainDuplicate;

import java.util.HashSet;

public class ContainDuplicate {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<>();

        for (Integer i : nums) {
            if (seen.contains(i)) {
                return true;
            }

            seen.add(i);
        }


        return false;
    }

    public static void main(String[] args) {
        ContainDuplicate checker = new ContainDuplicate();

        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {1, 2, 3, 1};

        System.out.println("nums1 has duplicate: " + checker.containsDuplicate(nums1)); // false
        System.out.println("nums2 has duplicate: " + checker.containsDuplicate(nums2)); // true
    }
}
