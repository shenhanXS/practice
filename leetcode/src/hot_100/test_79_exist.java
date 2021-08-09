package hot_100;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；
 * 否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *
 * @author Shenhan
 * @create 2021-06-28-10:30
 */
public class test_79_exist {

    boolean flag = false;

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    int[][] record = new int[board.length][board[0].length];
                    record[i][j] = 1;
                    dfs(board, word.substring(1), "", i, j, record);
                }
            }
        }
        return flag;
    }
    public void dfs(char[][] board, String word, String sourceDirection, int i, int j, int[][] record){
        if (word.length() == 0){
            flag = true;
            return;
        }
        if (sourceDirection != "UP" && i != 0){
            if (record[i - 1][j] != 1 && board[i - 1][j] == word.charAt(0)){
                record[i - 1][j] = 1;
                dfs(board, word.substring(1), "DOWN", i - 1, j, record);
                record[i - 1][j] = 0;
            }
        }
        if (sourceDirection != "DOWN" && i < board.length - 1){
            if (record[i + 1][j] != 1 && board[i + 1][j] == word.charAt(0)){
                record[i + 1][j] = 1;
                dfs(board, word.substring(1), "UP", i + 1, j, record);
                record[i + 1][j] = 0;
            }
        }
        if (sourceDirection != "LEFT" && j != 0){
            if (record[i][j - 1] != 1 && board[i][j - 1] == word.charAt(0)){
                record[i][j - 1] = 1;
                dfs(board, word.substring(1), "RIGHT", i, j - 1, record);
                record[i][j - 1] = 0;
            }
        }
        if (sourceDirection != "RIGHT" && j < board[0].length - 1){
            if (record[i][j + 1] != 1 && board[i][j + 1] == word.charAt(0)){
                record[i][j + 1] = 1;
                dfs(board, word.substring(1), "LEFT", i, j + 1, record);
                record[i][j + 1] = 0;
            }
        }
    }

}
