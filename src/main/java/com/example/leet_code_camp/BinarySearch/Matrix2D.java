package com.example.leet_code_camp.BinarySearch;

public class Matrix2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        int left = 0;
        int right = numRows * numCols - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int row = mid / numCols;
            int col = mid % numCols;
            int midVal = matrix[row][col];

            if (midVal == target) {
                return true;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return false;
    }
}
