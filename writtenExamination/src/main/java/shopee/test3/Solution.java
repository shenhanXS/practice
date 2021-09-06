package shopee.test3;

import java.util.Arrays;

/**
 * @author Shenhan
 * @create 2021-09-06-19:00
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] weights = {8,3,12,7,9,7};
        int v = 24;
        System.out.println(s.bestFit(v, weights));
    }

    int maxSum = 0;
    public int bestFit(int v, int[] weights) {
        Arrays.sort(weights);
        for (int i = 0; i < weights.length; i++) {
            if (maxSum == v) return 0;
            dfs(i, weights, weights[i], v);
        }
        return v - maxSum;
    }
    public void dfs(int index, int[] weights, int temp, int v) {
        for (int i = index + 1; i < weights.length; i++) {
            if (temp + weights[i] <= v) {
                maxSum = Math.max(maxSum, temp + weights[i]);
                if (maxSum == v) return;
                dfs(i, weights, temp + weights[i], v);
            }else {
                maxSum = Math.max(maxSum, temp);
                if (maxSum == v) return;
                break;
            }
        }
        maxSum = Math.max(maxSum, temp);
    }

}
