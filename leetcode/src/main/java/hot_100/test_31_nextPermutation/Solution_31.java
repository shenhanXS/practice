package hot_100.test_31_nextPermutation;

import java.util.Arrays;

/**
 *
 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须 原地 修改，只允许使用额外常数空间。
 *
 * @author Shenhan
 * @create 2021-05-31-10:53
 */
public class Solution_31 {

    public static void main(String[] args) {

        int[] nums = {1,3,5,4,1};
//        Arrays.sort(nums, 2, 5);

        Solution_31 test_31 = new Solution_31();
        test_31.nextPermutation(nums);
        for (int num:nums
             ) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {

        int flag = nums.length - 1;
        while (flag-1>=0 && nums[flag-1] >= nums[flag]) flag--;
        if (flag == 0){
            Arrays.sort(nums);
        }else {
            int k = flag - 1;
            while (flag+1 < nums.length && nums[k] < nums[flag+1]) flag++;
            int temp = nums[k];
            nums[k] = nums[flag];
            nums[flag] = temp;
            Arrays.sort(nums, k+1, nums.length);
        }

    }
}
