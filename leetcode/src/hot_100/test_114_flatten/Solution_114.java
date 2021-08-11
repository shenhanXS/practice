package hot_100.test_114_flatten;

import hot_100.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author Shenhan
 * @create 2021-07-11-16:40
 */
public class Solution_114 {

    // 官方解法3 寻找前驱节点
    public void flatten(TreeNode root) {
        TreeNode curNode = root;
        while (curNode != null){
            if (curNode.left != null) {
                TreeNode left = curNode.left;
                TreeNode preNode = left;
                while (preNode.right != null){
                    preNode = preNode.right;
                }
                preNode.right = curNode.right;
                curNode.right = left;
                curNode.left = null;
            }
            curNode = curNode.right;
        }
    }

    /*
    // 官方解法1 递归实现
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorderTraversal(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode preNode = list.get(i - 1);
            TreeNode curNode = list.get(i);
            preNode.left = null;
            preNode.right = curNode;
        }
    }
    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
     */

}
