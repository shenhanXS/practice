package JD.test2021.test2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-21-19:31
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] nums = splitNums(s);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }
    }

    public static int[] splitNums(String s) {
        int[] dp = new int[s.length()];
        int[][] ratio = new int[s.length()][2];
        // 初始化ratio
        if (s.charAt(0) == '0') {
            ratio[0][0] = 1;
        } else {
            ratio[0][1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                ratio[i][0] = ratio[i - 1][0] + 1;
                ratio[i][1] = ratio[i - 1][1];
            } else {
                ratio[i][0] = ratio[i - 1][0];
                ratio[i][1] = ratio[i - 1][1] + 1;
            }
        }
        // 更新dp数组
        for (int i = 0; i < dp.length; i++) {
            if (ratio[i][0] == 0 || ratio[i][1] == 0) {
                dp[i] = Math.max(ratio[i][0], ratio[i][1]);
            } else if (ratio[i][0] == 1 || ratio[i][1] == 1) {
                dp[i] = 1;
            } else {
                int c = ratio[i][0], d = ratio[i][1];
                int minRatio = 1;
                for (int j = 1; j <= c; j++) {
                    if ((j * d / c) * c == j * d) {
                        minRatio = j;
                        break;
                    }
                }
                int temp = 0;
                int len = minRatio + (minRatio * d) / c;
                for (int j = 1; i - j * len > 0; j++) {
                    int flag = i - j * len;
                    int a = ratio[flag][0], b = ratio[flag][1];
                    if (a * d == b * c) {
                        temp = dp[flag];
                        break;
                    }
                }
                dp[i] = temp + 1;

            }
        }
        return dp;
    }


}
