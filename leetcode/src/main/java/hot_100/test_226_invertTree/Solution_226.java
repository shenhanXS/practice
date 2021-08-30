package hot_100.test_226_invertTree;

import hot_100.TreeNode;

/**
 * 翻转一棵二叉树。
 *
 * @author Shenhan
 * @create 2021-08-27-20:52
 */
public class Solution_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        turn(root);
        return root;
    }
    public void turn(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if (root.left != null) {
            turn(root.left);
        }
        if (root.right != null){
            turn(root.right);
        }
    }

}
