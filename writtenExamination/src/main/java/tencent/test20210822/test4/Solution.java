package tencent.test20210822.test4;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-22-20:43
 */
public class Solution {

    static int[] nums;
    static String res = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = s.charAt(i) - 'a';
        }
        getMaxString(len, k, s, 0);
        System.out.println(res);
    }
    public static void getMaxString(int len, int k, String s, int begin) {
        if (len == k) {
            res += s.substring(s.length() - k);
            return;
        }
        int flag = begin;
        for (int i = begin; i <= s.length() - k; i++) {
            if (nums[i] > nums[flag]) {
                flag = i;
            }
        }
        res += s.substring(flag, flag + 1);
        getMaxString(s.length() - flag - 1, k - 1, s, flag + 1);
    }


}
