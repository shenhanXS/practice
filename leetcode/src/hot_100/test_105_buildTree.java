package hot_100;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * @author Shenhan
 * @create 2021-07-08-20:43
 */
public class test_105_buildTree {

    private HashMap<Integer, Integer> indexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode dfs = dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return dfs;
    }
    // 方法中添加了4个值分别维护本次方法需要使用的preorder以及inorder的左右边界
    public TreeNode dfs(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        int preorderRoot = preorderLeft;
        TreeNode node = new TreeNode(preorder[preorderRoot]);
        int inorderRoot = indexMap.get(node.val);
        int subLeftTreeSize = inorderRoot - inorderLeft;
        int subRightTreeSize = inorderRight - inorderRoot;
        if (subLeftTreeSize > 0){
            node.left = dfs(preorder, inorder, preorderLeft + 1, preorderLeft + subLeftTreeSize, inorderLeft, inorderLeft + subLeftTreeSize - 1);
        }
        if (subRightTreeSize > 0){
            node.right = dfs(preorder, inorder, preorderLeft + subLeftTreeSize + 1, preorderRight, inorderRoot + 1, inorderRight);
        }
        return node;
    }


    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> list = Arrays.stream(preorder).boxed().collect(Collectors.toList());
        List<Integer> list1 = Arrays.stream(inorder).boxed().collect(Collectors.toList());
        return dfs(list, list1);
    }
    public TreeNode dfs(List<Integer> preorder, List<Integer> inorder){
        if (preorder.size() == 0) return null;
        TreeNode node = new TreeNode(preorder.get(0));
        if (preorder.size() == 1){
            return node;
        }
        int i = inorder.indexOf(node.val);
        List<Integer> inorderLeftSub = inorder.subList(0, i);
        List<Integer> inorderRightSub = inorder.subList(i + 1, inorder.size());
        List<Integer> preorderLeftSub = preorder.subList(1, 1 + i);
        List<Integer> preorderRightSub = preorder.subList(1 + i, preorder.size());
        node.left = dfs(preorderLeftSub, inorderLeftSub);
        node.right = dfs(preorderRightSub, inorderRightSub);
        return node;
    }
     */
}
