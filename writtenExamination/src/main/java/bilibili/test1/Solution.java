package bilibili.test1;

import org.junit.Test;

import java.util.*;

/**
 * @author Shenhan
 * @create 2021-08-25-19:31
 */
public class Solution {

    public List<Integer> multiply(int[] nums, int s) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (!set.contains(s - nums[i])) {
                set.add(nums[i]);
            }else {
                list.add(Arrays.asList(nums[i], s - nums[i], nums[i] * (s - nums[i])));
            }
        }
        if (list.size() == 0) {
            return null;
        }else {
            list.sort(Comparator.comparingInt(o -> o.get(2)));
            return Arrays.asList(list.get(0).get(0), list.get(0).get(1));
        }
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {1, 9};
        int k = 10;
        List<Integer> list = s.multiply(nums, k);
        System.out.println(list);

    }

}
