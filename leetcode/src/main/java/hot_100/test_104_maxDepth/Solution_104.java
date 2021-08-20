package hot_100.test_104_maxDepth;

import hot_100.TreeNode;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author Shenhan
 * @create 2021-07-08-20:35
 */
public class Solution_104 {

    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }
    public void dfs(TreeNode root, int depth){
        if (root == null) return;
        maxDepth = Math.max(depth, maxDepth);
        if (root.left != null){
            dfs(root.left, depth + 1);
        }
        if (root.right != null){
            dfs(root.right, depth + 1);
        }
    }
}
