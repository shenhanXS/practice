package hot_100.test_96_numTrees;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 *
 * @author Shenhan
 * @create 2021-06-29-20:49
 */
public class Solution_96 {

    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        // 官方解法1 dp
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }
}
