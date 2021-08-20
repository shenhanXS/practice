package meituan.Test2021.test3;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-15-11:47
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] position = new int[n][2];
        for (int i = 0; i < n; i++) {
            position[i][0] = scanner.nextInt();
            position[i][1] = scanner.next() == "R" ? 0 : 1;
        }


    }

    public static int f(int i, int flag) {
        if (flag == 0) {
            return i + 1;
        }
        return i - 1;
    }
}
