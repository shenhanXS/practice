package hot_100.test_200_numIslands;

/**
 *
 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

 此外，你可以假设该网格的四条边均被水包围。
 *
 * @author Shenhan
 * @create 2021-08-11-16:51
 */
public class Solution_200 {

    // 最终版 , 如果题目要求不能改变原数组，则新建一个数组用来存储标计，然后计数，参考初版做法
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++; // 直接记录dfs次数即为所求结果
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            // 上
            dfs(grid, i - 1, j);
            // 下
            dfs(grid, i + 1, j);
            // 左
            dfs(grid, i, j - 1);
            // 右
            dfs(grid, i, j + 1);
        }
    }


    /* 初版
    private char[][] flag;
    public int numIslands(char[][] grid) {
        flag = new char[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && flag[i][j] == '\u0000') {
                    flag[i][j] = '1';
                    // 上
                    dfs(grid, i - 1, j);
                    // 下
                    dfs(grid, i + 1, j);
                    // 左
                    dfs(grid, i, j - 1);
                    // 右
                    dfs(grid, i, j + 1);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < flag.length; i++) {
            for (int j = 0; j < flag[i].length; j++) {
                if (flag[i][j] == '1') count++;
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1' && flag[i][j] == '\u0000') {
            flag[i][j] = '0';
            // 上
            dfs(grid, i - 1, j);
            // 下
            dfs(grid, i + 1, j);
            // 左
            dfs(grid, i, j - 1);
            // 右
            dfs(grid, i, j + 1);
        }
    }
     */
}
