package hot_100;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 * @author Shenhan
 * @create 2021-06-22-10:20
 */
public class test_55_canJump {

    public static void main(String[] args) {
        int[] nums = {0};
        test_55_canJump test_55 = new test_55_canJump();
        System.out.println(test_55.canJump(nums));
    }

    // 官方解法 贪心
    public boolean canJump(int[] nums) {
        int rightmax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightmax){
                rightmax = Math.max(rightmax, i + nums[i]);
                if (rightmax >= nums.length - 1){
                    return true;
                }
            }else {
                return false;
            }
        }
        return false;
    }

    /*
    public boolean canJump(int[] nums) {
        if (nums.length > 1 && nums[0] == 0){
            return false;
        }
        int temp = nums.length - 1;
        if (nums[temp] == 0){
            for (int i = temp; i > 0; i--) {
                temp--;
                if (nums[i] == 0){
                    break;
                }
            }
        }
        for (int i = temp; i >0 ; i--) {
            boolean flag;
            if (nums[i] == 0){
                flag = true;
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] - nums[i] > i - j){
                        flag = false;
                        i = j;
                        break;
                    }
                }
                if (flag) return false;
            }
        }
        return true;
    }
     */
}
