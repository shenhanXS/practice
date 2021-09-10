package hot_100.test_279_numSquares;

import org.junit.jupiter.api.Test;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。
 * 例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 *
 * @author Shenhan
 * @create 2021-09-10-20:53
 */
public class Solution_279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int temp = (int) Math.sqrt(n);
        if (n - temp * temp == 0) {
            return 1;
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            temp = (int) Math.sqrt(i);
            if (i - temp * temp == 0) {
                dp[i] = 1;
            }else {

            }
        }
        return dp[n];
    }

    @Test
    public void test(){
        int x = (int) Math.sqrt(12);
        System.out.println(x);

    }

}
