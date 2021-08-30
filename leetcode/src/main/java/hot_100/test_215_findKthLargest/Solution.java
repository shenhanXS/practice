package hot_100.test_215_findKthLargest;

import java.util.Random;

/**
 *
 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author Shenhan
 * @create 2021-08-24-19:35
 */
public class Solution {

    // 利用快排的思想 , 时间复杂度O(n)
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int targetIndex = len - k;
        int left = 0, right = len - 1;
        while (true) {
            int i = partition(nums, left, right);
            if (i == targetIndex) {
                return nums[i];
            } else if (i < targetIndex) {
                left = i + 1;
            }else {
                right = i - 1;
            }
        }
    }
    private int partition(int[] nums, int left, int right) {
        // 做一个随机取值操作 , 有效提高特殊情况下的运行效率
        if (right > left) {
            int random = left + new Random().nextInt(right - left);
            swap(nums, random, right);
        }
        int i = left;
        int value = nums[right];
        for (int j = i; j < right; j++) {
            if (nums[j] < value) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
