package hot_100;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author Shenhan
 * @create 2021-06-24-20:21
 */
public class test_64_minPathSum {

    public int minPathSum(int[][] grid) {
        int[][] f = new int[grid.length][grid[0].length];
        f[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                f[i][j] = grid[i][j] + Math.min(f[i - 1][j], f[i][j - 1]);
            }
        }
        return f[f.length - 1][f[0].length - 1];
    }
}
