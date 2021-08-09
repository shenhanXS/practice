package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * @author Shenhan
 * @create 2021-06-10-17:01
 */
public class test_39_combinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        test_39_combinationSum test_39 = new test_39_combinationSum();
        int[] candicates = {2,3,6,7};
        int target = 7;
        test_39.combinationSum(candicates, target);
        System.out.println(test_39.result);
    }

    // dfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, list);

        return result;
    }
    public void dfs(int[] candidates, int target, int index, List<Integer> list){
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] == target) {
                list.add(candidates[i]);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }else if (candidates[index] < target){
                list.add(candidates[i]);
                dfs(candidates, target-candidates[i], i, list);
                list.remove(list.size() - 1);
            }else {
                return;
            }
        }
    }

}
