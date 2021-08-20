package hot_100.test_102_levelOrder;

import hot_100.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * @author Shenhan
 * @create 2021-07-08-20:27
 */
public class Solution_102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 1, list);
        return list;
    }
    public void dfs(TreeNode root, int level, List<List<Integer>> list){
        if (root == null) return;
        if (level > list.size()){
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            list.add(temp);
        }else {
            list.get(level - 1).add(root.val);
        }
        if (root.left != null){
            dfs(root.left, level + 1, list);
        }
        if (root.right != null){
            dfs(root.right, level + 1, list);
        }
    }
}
