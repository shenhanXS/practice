package netEase.test2021.test3;

import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-21-14:59
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] ages = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            ages[i] = Integer.parseInt(s1[i]);
        }
        int[] nums = dp(ages);
        int res = 0;
        for (int j = 0; j < ages.length; j++) {
            System.out.print(nums[j] + " ");
            res += nums[j];
        }
        System.out.println(res);
    }
    public static int[] dp(int[] ages){
        int[] nums = new int[ages.length];
        nums[0] = 1;
        for (int j = 1; j < ages.length; j++) {
            if (ages[j] > ages[j - 1]) {
                nums[j] = nums[j - 1] + 1;
            }else if (ages[j] == ages[j - 1]) {
                nums[j] = 1;
            }else {
                nums[j] = 1;
                if (nums[j - 1] == 1) {
                    int temp = j - 1;
                    while (temp >= 0 && ages[temp] > ages[temp + 1]) {
                        nums[temp] = Math.max(nums[temp], nums[temp + 1] + 1);
                        temp--;
                    }
                }
            }
        }
        return nums;
    }


    /*
    public static int[] dp(int[] ages){
        int[] nums = new int[ages.length];
        nums[0] = 1;
        for (int j = 1; j < ages.length; j++) {
            if (ages[j] > ages[j - 1]) {
                nums[j] = nums[j - 1] + 1;
            }else if (ages[j] == ages[j - 1]) {
                nums[j] = 1;
            }else {
                int flag = 1, temp = j;
                while (temp + 1 < ages.length && ages[temp] > ages[temp + 1]) {
                    temp++;
                    flag++;
                }
                j = temp;
                nums[temp] = 1;
                while (flag > 0) {
                    nums[temp - 1] = nums[temp] + 1;0
                    temp--;
                    flag--;
                }
            }
        }
        return nums;
    }

     */


}
