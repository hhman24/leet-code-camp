package com.example.leet_code_camp.TowPointer.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            else if (sum < target) {
                left++;
            }
            else  {
                right--;
            }
        }

        return res;
    }
}
