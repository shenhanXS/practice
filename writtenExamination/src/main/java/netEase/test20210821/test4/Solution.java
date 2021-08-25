package netEase.test20210821.test4;

/**
 * @author Shenhan
 * @create 2021-08-21-15:51
 */
public class Solution {

    /*
    1 1 1 1 0
    0 1 0 1 0
    1 1 2 1 1
    0 2 0 0 1
     */
    public int minSailCost(int[][] input) {
        int[][] dp = new int[input.length][input[0].length];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 2) dp[i][j] = -1;
            }
        }

        while (dp[dp.length - 1][dp[0].length - 1] != 0){

        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
    public void update(int i, int j, int[][] dp, int[][] input){
        // 上
        if (i - 1 >= 0 && dp[i - 1][j] != -1) {
            int temp = input[i - 1][j] == 0 ? 2 : 1;
            dp[i - 1][j] = Math.min(dp[i - 1][j], dp[i][j] + temp);
        }
        // 下

        // 左
        // 右
    }

}
