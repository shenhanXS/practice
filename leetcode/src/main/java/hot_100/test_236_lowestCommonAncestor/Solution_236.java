package hot_100.test_236_lowestCommonAncestor;

import hot_100.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * @author Shenhan
 * @create 2021-08-31-16:34
 */
public class Solution_236 {

    // 官方解法二 用哈希表存储所有节点的父节点
    HashMap<Integer, TreeNode> parentMap = new HashMap<>();
    HashSet<Integer> visitedSet = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visitedSet.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visitedSet.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return root;
    }
    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs(root.right);
        }
    }


    /*
    // 官方解法一 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root == p || root == q) return root;
        // 分为左右两边的子问题进行递归判断
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) return root;
        return leftNode != null ? leftNode : rightNode;
    }
     */
}
