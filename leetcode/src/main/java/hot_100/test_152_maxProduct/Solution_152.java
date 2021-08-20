package hot_100.test_152_maxProduct;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 *
 * @author Shenhan
 * @create 2021-08-05-16:48
 */
public class Solution_152 {

    // 官方解法 dp
    public int maxProduct(int[] nums) {
        int multiply = nums[0];
        int minus = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int multi = multiply;
            multiply = Math.max(multiply * nums[i], Math.max(nums[i], nums[i] * minus));
            minus = Math.min(minus * nums[i], Math.min(nums[i], nums[i] * multi));
            max = Math.max(multiply, max);
        }
        return max;
    }

    /*
    // 两次循环，正反各一次。妙哉
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int dp = 1;
        for(int i = 0;i < n;i++){
            dp *= nums[i];
            max = Math.max(max,dp);
            if(dp == 0) dp = 1;
        }
        dp = 1;
        for(int i = n-1;i >= 0;i--){
            dp *= nums[i];
            max = Math.max(max,dp);
            if(dp == 0) dp = 1;
        }
        return max;
    }
     */

}
