package meituan.Test2021.test1;

import java.util.Arrays;

/**
 * @author Shenhan
 * @create 2021-08-15-11:17
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2,1,3};
        System.out.println(solution.f(nums.length, nums));
    }


    public String f(int len, int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + 1 != nums[i]) {
                return "No";
            }
        }
        return "Yes";
    }

}
