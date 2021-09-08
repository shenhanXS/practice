package xiaomi.test20210908.test2;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-08-19:31
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        nums = sort(nums);
        for (int i = 0; i < 9; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println(nums[9]);
    }
    public static int[] sort(int[] nums) {
        int left = 0, right = nums.length - 1;
        int one = 0;
        while (left <= right) {
            if (nums[left] == 1) {
                int temp = nums[one];
                nums[one] = nums[left];
                nums[left] = temp;
                one++;
                left++;
            }else if (nums[left] == 3) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right--;
            }else {
                left++;
            }
        }
        return nums;
    }

}
