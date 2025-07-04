package com.example.leet_code_camp.Array;

import java.util.*;

/*
 * The idea is to store sum of all the pairs with their indices in the hash map or dictionary.
 * Then, for each element in the array, we check if the pair which makes triplet's sum zero,
 * exists in the hash map or not. Since there can be multiple valid pairs, we add each one to
 * the hash set (to manage duplicates) while ensuring that all indices in the triplet are distinct.
 * */

// Use Case
/*
 * Tìm kiếm bộ ba số có tổng bằng 0 - bài toán về tài chính, xử lý dữ liệu, và kiểm tra tính hợp lệ của dữ liệu số.
 * Trong game - 3 yếu tố triệt tiêu lẫn nhau (âm, dương, trung hòa).
 * Trong bảo mật, kiểm tra các tổ hợp số dẫn đến trạng thái “trung hòa”.
 * */

public class TreeSum {
    public List<List<Integer>> threeSumUsingBySet(int[] nums) {
        // Set to handle duplicates
        Set<List<Integer>> resSet = new HashSet<>();
        Map<Integer, List<int[]>> pairSumMap = new HashMap<>();
        int n = nums.length;

        // Building Hashmap to store all indices sum
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                pairSumMap.computeIfAbsent(nums[i] + nums[j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // For each index k, look for target = -nums[k]
        for (int k = 0; k < n; k++) {
            int target = -nums[k];
            if (pairSumMap.containsKey(target)) {
                for (int[] pair : pairSumMap.get(target)) {
                    int i = pair[0], j = pair[1];

                    // Ensure no two indices are same in triplet
                    if (i != k && j != k) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(triplet);  // Sort to ensure uniqueness in Set
                        resSet.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(resSet);
    }


    public List<List<Integer>> threeSumSolver(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort array first
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // ignore duplicate element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
