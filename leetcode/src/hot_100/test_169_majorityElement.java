package hot_100;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author Shenhan
 * @create 2021-08-09-16:26
 */
public class test_169_majorityElement {

    public static void main(String[] args) {
        test_169_majorityElement test_169 = new test_169_majorityElement();
        int[] nums = {3,2,3};
        System.out.println(test_169.majorityElement(nums));
    }

    // 位运算
    public int majorityElement(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < count.length; i++) {
                count[i] += num & 1;
                num >>>= 1;
            }
        }
        int result = 0;
        int halfLength = nums.length / 2;
        for (int i = 0; i < count.length; i++) {
            result <<= 1;
            if (count[31 - i] > halfLength) {
                result |= 1;
            }
        }
        return result;
    }

    /*
    // 官方解法五 摩尔投票法
    // 时间复杂度O(n) , 空间复杂度O(1)
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
     */

    /*
    // 官方解法四 分治
    // 时间复杂度O(n log n) , 空间复杂度O(log n)
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
    private int majorityElementRec(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = (l + r) / 2;
        int left = majorityElementRec(nums, l, mid);
        int right = majorityElementRec(nums, mid + 1, r);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, l, mid);
        int rightCount = countInRange(nums, right, mid + 1, r);
        return leftCount > rightCount ? left : right;
    }
    private int countInRange(int[] nums, int num, int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }
     */
}
