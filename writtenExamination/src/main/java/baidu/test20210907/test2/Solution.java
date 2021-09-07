package baidu.test20210907.test2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-07-19:48
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            System.out.println(f(n));
        }
    }
    public static long f(long n) {
        long[] nums = new long[20];
        Arrays.fill(nums, -2);
        for (int i = 19; n != 0; i--) {
            nums[i] = n % 10;
            n = (n - nums[i]) / 10;
        }
        for (int i = 19; i > 0; i--) {
            if (nums[i] == -2) {
                break;
            }
            if (nums[i] > 3) {
                nums[i] = 3;
                for (int j = i + 1; j < 20; j++) {
                    nums[j] = 3;
                }
            }else if (nums[i] <= 0) {
                if (nums[i - 1] >= 0) {
                    nums[i - 1]--;
                    nums[i] = 3;
                    for (int j = i + 1; j < 20; j++) {
                        nums[j] = 3;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            res = res * 10 + nums[i];
        }
        return res;
    }



}
