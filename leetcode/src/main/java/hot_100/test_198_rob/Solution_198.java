package hot_100.test_198_rob;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author Shenhan
 * @create 2021-08-11-14:57
 */
public class Solution_198 {

    public static void main(String[] args) {
        Solution_198 solution_198 = new Solution_198();
        int[] nums = {2,7,9,3,1};
        System.out.println(solution_198.rob(nums));
    }

    // 进一步简化 , 最终版
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(first + nums[i], second);
            first = second;
            second = temp;
        }
        return second;
    }

    /*
    // 看了官方解法改进后的dp , 时间复杂度O(n) , 空间复杂度O(1)
    // 使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是O(1)。
    public int rob(int[] nums) {
        int[] endWithNMaxCount = new int[3];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        endWithNMaxCount[0] = nums[0];
        endWithNMaxCount[1] = nums[1];
        endWithNMaxCount[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            int temp = Math.max(endWithNMaxCount[0], endWithNMaxCount[1]) + nums[i];
            endWithNMaxCount[0] = endWithNMaxCount[1];
            endWithNMaxCount[1] = endWithNMaxCount[2];
            endWithNMaxCount[2] = temp;
        }
        return Math.max(endWithNMaxCount[1], endWithNMaxCount[2]);
    }
     */

    /*
    // 自己写的dp , 时间复杂度O(n) , 空间复杂度O(n)
    public int rob(int[] nums) {
        // 记录以该位置为结尾的最高金额
        int[] endWithNMaxCount = new int[nums.length];
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        if (nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);
        endWithNMaxCount[0] = nums[0];
        endWithNMaxCount[1] = nums[1];
        endWithNMaxCount[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            endWithNMaxCount[i] = Math.max(endWithNMaxCount[i - 2], endWithNMaxCount[i - 3]) + nums[i];
        }
        // 返回最后一个结尾和次一位结尾的两个值中的最大值
        return Math.max(endWithNMaxCount[nums.length - 1], endWithNMaxCount[nums.length - 2]);
    }
     */
}
