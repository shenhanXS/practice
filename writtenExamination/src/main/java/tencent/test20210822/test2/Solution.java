package tencent.test20210822.test2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-22-20:08
 */
public class Solution {

    static int base = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            int max = getMax(nums);
            System.out.println(max);
        }
    }
    public static int getMax(int[] nums) {
        int max = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = len - 1; i >= 0; i--) {
//            int ratio = 1;
//            for (int j = 0; j < i; j++) {
//                ratio = ratio << 1;
//            }
            if (i <= 20) {
                max = max + nums[i] * (1 << i);
            }else {

            }
            max /= base;
        }
        return max;
    }


}
