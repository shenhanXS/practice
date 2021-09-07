package shopee.test3;

import java.util.Arrays;

/**
 * @author Shenhan
 * @create 2021-09-06-19:00
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] weights = {3,8,7,9,12,6,7};
        int v = 24;
        System.out.println(s.bestFit(v, weights));
    }

    public int bestFit(int v, int[] weights) {
        // 二维dp , dp[i][j]表示在只使用weights前i个货物情况下，容积不超过j的最大value和
        int[][] dp = new int[weights.length + 1][v + 1];
        for (int i = 0; i < weights.length; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (j >= weights[i]) {
                    dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - weights[i]] + weights[i]);
                } else {
                    dp[i + 1][j] = dp[i][j];
                }
            }
        }
        int[] flag = new int[weights.length + 1];

        return v - dp[weights.length][v];
        /* 一维dp
        // dp[i] 表示容积不超过i的最大value和
        int[] dp = new int[v + 1];
        for (int weight : weights) {
            for (int j = v; j > 0; j--) {
                if (j >= weight) {
                    dp[j] = Math.max(dp[j], dp[j - weight] + weight);
                }
            }
        }
        return v - dp[v];
         */
    }


}
