package hot_100.test_33_search;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * @author Shenhan
 * @create 2021-06-08-11:01
 */
public class Solution_33 {

    public static void main(String[] args) {
        Solution_33 test_33 = new Solution_33();
        int[] nums = {1,3};
        int target = 3;
        System.out.println(test_33.search(nums, target));
    }

    //时间复杂度 O(log n)
    // 二分查找
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (target > nums[mid]){
                if (nums[left] < nums[mid]){
                    left = mid + 1;
                }else {
                    if (target <= nums[right]){
                        left = mid + 1;
                    }else {
                        right = mid - 1;
                    }
                }
            }else {
                if (nums[right] > nums[mid]){
                    right = mid - 1;
                }else {
                    if (target >= nums[left]){
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;

    }

    /*
    时间复杂度O(n)
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

     */
}
