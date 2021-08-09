package hot_100;

/**
 * @author Shenhan
 * @create 2021-06-24-20:47
 */
public class test_75_sortColors {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int zero = 0;
        while (left <= right){
            if (nums[left] == 0){
                swap(nums, left, zero);
                zero++;
                left++;
            }else if (nums[left] == 1){
                left++;
            }else {
                swap(nums, left, right);
                right--;
            }
        }

    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
