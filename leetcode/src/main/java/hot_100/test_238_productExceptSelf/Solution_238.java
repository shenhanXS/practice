package hot_100.test_238_productExceptSelf;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * @author Shenhan
 * @create 2021-09-03-15:06
 */
public class Solution_238 {

    public static void main(String[] args) {
        Solution_238 solution_238 = new Solution_238();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(solution_238.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int temp = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }

}
