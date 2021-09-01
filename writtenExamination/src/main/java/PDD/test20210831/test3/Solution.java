package PDD.test20210831.test3;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-31-19:13
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();
            long maxNum = getMaxNum(n);
            System.out.println(maxNum);
        }
    }

    public static long getMaxNum(long n) {
        long temp = 0;
//        for (long i = 0; i < n; i++) {
//            if (2 * i * (i + 1) >= n) {
//                temp = i - 1;
//                break;
//            }
//        }
        temp = (long) ((Math.sqrt(2*n + 1) - 1) / 2);
        long num = 2 * temp * (temp + 1);
        if (n < num + 3) {
            return temp * temp;
        } else if (n <= num + 2 * temp + 1) {
            long i = (num + 2 * temp + 1) - n;
            long j = i / 2;
            long k = i % 2;
            return k == 0 ? temp * (temp + 1) - j : temp * (temp + 1) - j - 1;
        } else if (n < num + 2 * temp + 4) {
            return temp * (temp + 1);
        }else {
            long i = 2 * (temp + 1) * (temp + 2) - n;
            long j = i / 2;
            long k = i % 2;
            return k == 0 ? (temp + 1) * (temp + 1) - j : (temp + 1) * (temp + 1) - j - 1;
        }


        /*
        long max = 3;
        if (l < 4) {
            return 0;
        }else if (l < 7) {
            return 1;
        }else if (l < 10) {
            return 2;
        }else {
            long i = (l - 10) / 5;
            max += i * 2;
            long j = (l - 10) % 5;
            if (j >= 2) {
                max++;
            }
        }
        return max;

         */
    }
}
