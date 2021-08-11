package hot_100.test_46_permute;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author Shenhan
 * @create 2021-06-19-15:15
 */
public class Solution_46 {

    private List<List<Integer>> result = new ArrayList<>();

    // 增加一个visited数组记录已访问的位置代替contains判断,稍做改进
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        dfs(nums, list, visited);
        return result;
    }
    public void dfs(int[] nums, List<Integer> list, int[] visited){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == 0){
                    list.add(nums[i]);
                    visited[i] = 1;
                    dfs(nums, list, visited);
                    list.remove(list.size() - 1);
                    visited[i] = 0;
                }
            }
        }
    }

    /* 初版
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();
        dfs(nums, list);
        return result;
    }
    public void dfs(int[] nums, List<Integer> list){
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!list.contains(nums[i])){
                    list.add(nums[i]);
                    dfs(nums, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

     */

}
