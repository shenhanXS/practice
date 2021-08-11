package hot_100.test_128_longestConsecutive;

import java.util.HashSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author Shenhan
 * @create 2021-07-22-16:48
 */
public class Solution_128 {

    public static void main(String[] args) {
        Solution_128 test_128 = new Solution_128();
        int[] nums = {100,4,200,1,3,2};
        test_128.longestConsecutive(nums);
    }

    // 官方解法
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }
        int maxLen = 1, temp = 1;
        for (Integer i : set) {
            if (!set.contains(i - 1)){
                temp = 1;
                while (set.contains(++i)){
                    temp++;
                }
                maxLen = Math.max(maxLen, temp);
            }
        }
        return maxLen;
    }

    /* 排序再判断 时间复杂度超过o(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums.length;
        int maxLength = 1, temp = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] - nums[i - 1] == 1){
                temp++;
            }else {
                maxLength = Math.max(maxLength, temp);
                temp = 1;
            }
        }
        maxLength = Math.max(maxLength, temp);
        return maxLength;
    }
     */
}
