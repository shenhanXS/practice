package hot_100;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * @author Shenhan
 * @create 2021-06-09-10:46
 */
public class test_34_searchRange {

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 3;
        test_34_searchRange test_34 = new test_34_searchRange();
        int[] result = test_34.searchRange(nums, target);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        // 特殊情况的处理
        if (nums.length == 0) return result;
        if (nums.length == 1) return nums[0] == target ? new int[]{0, 0} : result;
        int left = findIndex(nums, target, "left");
        int right = findIndex(nums, target, "right") - 1;
        if (left <=  right && nums[left] == target) {
            result[0] = left;
            result[1] = right;
        }
        return result;
    }
    public int findIndex(int[] nums, int target, String left_or_right) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        int mid;
        while (left <= right) {
            mid = left + right >> 1;
            if (target < nums[mid] ||(left_or_right == "left" && target == nums[mid])) {
                right = mid - 1;
                ans = mid;
            } else{
                left = mid + 1;
            }
        }
        return ans;
    }

//    public int[] searchRange(int[] nums, int target) {
//        // 二分
//        int[] result = {-1, -1};
//        // 特殊情况的处理
//        if (nums.length == 0) return result;
//        int left = 0;
//        int right = nums.length - 1;
//        int mid;
//        // 先找left
//        while (nums[left] != target && left < right) {
//            mid = left + right >> 1;
//            if (target > nums[mid]) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        if (nums[left] == target) {
//            for (int i = left; i < nums.length && nums[i] == target; i++) {
//                right = i;
//            }
//            result[0] = left;
//            result[1] = right;
//            return result;
//        }
//        return result;
//    }


}
