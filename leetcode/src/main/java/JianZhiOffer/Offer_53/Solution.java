package JianZhiOffer.Offer_53;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @author Shenhan
 * @create 2021-08-27-19:43
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.missingNumber(nums));
    }

    // 二分法
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (mid == nums[mid]) {
                i = mid + 1;
            }else {
                j = mid - 1;
            }
        }
        return i;
    }
}
