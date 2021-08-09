package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Shenhan
 * @create 2021-07-01-14:34
 */
public class test_98_isValidBST {

    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return flag;
    }
    public void dfs(TreeNode root, List<Integer> list){
        if (flag){
            if (root == null) return;
            dfs(root.left, list);
            if (list.size() > 0 && flag){
                flag = root.val > list.get(list.size() - 1);
            }
            list.add(root.val);
            dfs(root.right, list);
        }
    }

}
