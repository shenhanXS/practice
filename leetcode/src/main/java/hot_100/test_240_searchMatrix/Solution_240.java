package hot_100.test_240_searchMatrix;

import org.junit.jupiter.api.Test;

/**
 * @author Shenhan
 * @create 2021-09-15-16:06
 */
public class Solution_240 {


    // 官方解法4
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }

        return false;
    }


    /*
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] left = {0, 0};
        int[] right = {rowLen - 1, colLen - 1};
        return isExist(matrix, target, left, right);
    }
    public boolean isExist(int[][] matrix, int target, int[] left, int[] right) {
        if (left[0] <= right[0] && left[1] <= right[1] && left[0] >= 0 && right[0] <= matrix.length && left[1] >= 0 && right[1] <= matrix[0].length) {
            if (left[0] == right[0] && left[1] == right[1]) {
                return target == matrix[left[0]][left[1]];
            }
            int[] mid = {(left[0] + right[0]) / 2, (left[1] + right[1]) / 2};
            if (matrix[mid[0]][mid[1]] == target) {
                return true;
            }else if (target < matrix[mid[0]][mid[1]]) {
                return isExist(matrix, target, left, new int[]{mid[0] - 1, mid[1] - 1}) ||
                        isExist(matrix, target, new int[]{left[0], mid[1]}, new int[]{mid[0] - 1, right[1]}) ||
                        isExist(matrix, target, new int[]{mid[0], left[1]}, new int[]{right[0], mid[1] - 1});
            }else {
                return isExist(matrix, target, new int[]{mid[0] + 1, mid[1] + 1}, right) ||
                        isExist(matrix, target, new int[]{left[0], mid[1] + 1}, new int[]{mid[0], right[1]}) ||
                        isExist(matrix, target, new int[]{mid[0] + 1, left[1]}, new int[]{right[0], mid[1]});
            }
        }
        return false;
    }
     */


}
