package hot_100.test_300_lengthOfLIS;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 *
 * @author Shenhan
 * @create 2021-09-03-16:29
 */
public class Solution_300 {

    public static void main(String[] args) {
        Solution_300 solution_300 = new Solution_300();
        int[] nums = {0,3,1,6,2,2,7};
        System.out.println(solution_300.lengthOfLIS(nums));
    }

    // 官方解法二 贪心＋二分查找
    // 时间复杂度O(n log(n)) , 空间复杂度O(n)
    public int lengthOfLIS(int[] nums) {
        // todo
        return 0;
    }


    /*
    // 官方解法一 dp
    // 时间复杂度o(n2) , 空间复杂度o(n)
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 1;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j]);
                }
            }
            dp[i] = temp + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
     */

}
