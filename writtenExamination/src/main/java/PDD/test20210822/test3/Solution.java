package PDD.test20210822.test3;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-22-18:59
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            int min = getMin(n, m);
            System.out.println(min);
        }
    }

    public static int getMin(int n, int m) {
        int num = 1;
        for (int i = 1; i < n; i++) {
            num *= 10;
        }
        num /= m;
        num = Math.max(num, 1);
        for (int i = num; i < Integer.MAX_VALUE; i++) {
            int temp = i * m;
            if (getLen(temp) == n) {
                return temp;
            }
            if (getLen(temp) > n) {
                return -1;
            }
        }
        return -1;
    }

    public static int getLen(int n) {
        int ans = 1;
        if (n >= 100000000) {
            n /= 100000000;
            ans += 8;
        }
        if (n >= 10000) {
            n /= 10000;
            ans += 5;
        }
        if (n >= 100) {
            n /= 100;
            ans += 2;
        }
        while (n >= 10) {
            n /= 10;
            ans += 1;
        }
        return ans;
    }

    /*
    public static int getLen(int num) {
        String s = num + "";
        return s.length();
    }

     */
}
