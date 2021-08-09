package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author Shenhan
 * @create 2021-06-28-10:05
 */
public class test_78_subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(list);
        int index = 0;
        dfs(nums, list, result, index);

        return result;
    }
    public void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, int index){
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            dfs(nums, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
