package hot_100;

/**
 *
 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

 问总共有多少条不同的路径？
 *
 * @author Shenhan
 * @create 2021-06-24-16:58
 */
public class test_62_uniquePaths {

    public static void main(String[] args) {
        test_62_uniquePaths test_62 = new test_62_uniquePaths();
        System.out.println(test_62.uniquePaths(51, 9));
    }


    // 官方解答方法一 dp 时间复杂度o(m*n)
    // 用二维数组存储到该位置路径个数
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    /*
    // 官方解答方法二 组合数学 时间复杂度o(min(m,n))
    // 转换为排列组合的数学题
    private int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
     */


    /* 最初通过方案
    public int uniquePaths(int m, int n) {
        if (m ==1 || n == 1){
            return 1;
        }else if (m == 2 || n == 2){
            return Math.max(m, n);
        }
        else if (m == n){
            return 2 * uniquePaths(m - 1, n);
        }else {
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }

     */

}
