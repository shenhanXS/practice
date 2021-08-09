package hot_100;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author Shenhan
 * @create 2021-05-19-9:56
 */
public class test_15_threeSum {

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        test_15_threeSum test_15_threeSum = new test_15_threeSum();
        List<List<Integer>> list = test_15_threeSum.threeSum(nums);
        System.out.println(list);
    }

    public List<List<Integer>> threeSum(int[] nums) {

        //双指针
        if(nums.length < 3){
            List<List<Integer>> list = new ArrayList<>();
            return list;
        }

        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int left, right, sum;

        for (int i = 0; i < nums.length - 2;) {
            if (nums[i] > 0) return list;
            left = i + 1;
            right = nums.length - 1;
            while (left < right){
                sum = nums[left] + nums[right] + nums[i];
                if (sum < 0){
                    left++;
                }else if (sum == 0){
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);
                }else {
                    right--;
                }
            }
            while (i < nums.length - 2 && nums[i] == nums[++i]);
        }

        return list;
    }
}
