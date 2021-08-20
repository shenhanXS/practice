package hot_100.test_53_maxSubArray;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author Shenhan
 * @create 2021-06-20-15:45
 */
public class Solution_53 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution_53 test_53 = new Solution_53();
        int i = test_53.maxSubArray(nums);
        System.out.println(i);

    }

    // 官方解法 dp
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }
        return max;
    }

    /*
    public int maxSubArray(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = 0;
        for (int i = 0; i < nums.length;) {
            sum += nums[i];
            if (sum > 0){
                i++;
                max = Math.max(max, sum);
            }else {
                i = nums[i] > 0 ? i : i+1;
                sum = 0;
            }
        }
        return max;
    }

     */
}
