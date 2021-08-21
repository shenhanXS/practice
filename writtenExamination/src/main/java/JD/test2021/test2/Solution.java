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
        for (int i = 0; i < dp.length; i++) {
            if (ratio[i][0] == 0 || ratio[i][1] == 0) {
                dp[i] = Math.max(ratio[i][0], ratio[i][1]);
            } else if (ratio[i][0] == 1 || ratio[i][1] == 1) {
                dp[i] = 1;
            } else {
                HashSet<Integer> set = get(Math.max(ratio[i][0], ratio[i][1]), Math.min(ratio[i][0], ratio[i][1]));
                if (set.size() == 0){
                    dp[i] = 1;
                }else {
                    for (Integer j : set) {
                        int temp = dp[j - 1];
                        int flag = j - 1;
                        for (int k = 2 * j; k < i; k*=k) {
                            if (dp[k - 1] > temp) {
                                flag = k - 1;
                                temp = dp[k - 1];
                            }
                        }
                        if (ratio[flag][0] * ratio[i][1] == ratio[flag][1] * ratio[i][0]) {
                            dp[i] = temp + 1;
                        }else {
                            dp[i] = 1;
                        }
                    }
                }
            }
        }
        return dp;
    }
    public static HashSet<Integer> get(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i <= a; ) {
            if (a % i == 0) {
                set.add(i);
                a /= i;//记得每次进行除i
            } else {
                i++;//之所以在这儿进行++的原因是需要求最小的，只有在不能被除尽的时候加一
            }
        }
        set.remove(1);
        return set;
    }

}
