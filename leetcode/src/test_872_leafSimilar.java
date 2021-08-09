
/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 *
 * @author Shenhan
 * @create 2021-05-10-9:46
 */
public class test_872_leafSimilar {

    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        preOrderTravel(root1, s1);
        preOrderTravel(root2, s2);

        return s1.toString().equals(s2.toString());
    }

    public void preOrderTravel(TreeNode root, StringBuilder result){

        if (root == null){
            return;
        }
        if (null == root.left && null == root.right){
            result.append(root.val+",");
            return;
        }
        if (root.left != null){
            preOrderTravel(root.left, result);
        }
        if (root.right != null){
            preOrderTravel(root.right, result);
        }


        /*
        String result = "";
        if (null == root.left && null == root.right){
            result += root.val;
            result += ",";
            return result;
        }
        if (null != root.left){
            result += preOrderTravel(root.left);
        }
        if (null != root.right){
            result += preOrderTravel(root.right);
        }

        return result;
         */
    }

}
