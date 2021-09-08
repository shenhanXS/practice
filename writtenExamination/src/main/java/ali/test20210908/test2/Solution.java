package ali.test20210908.test2;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-08-9:23
 */
public class Solution {

    static int flag = 0;
    static int num = 1;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            min = Integer.MAX_VALUE;
            getMinDiff(n, m);
            if (flag == 0) {
                System.out.println("H " + num);
            }else {
                System.out.println("V " + num);
            }
        }
    }
    static public void getMinDiff(int n, int m) {
        int[] rowSum = new int[n];
        int[] colSum = new int[m];
        rowSum[0] = (1 + m) * m / 2;
        for (int j = 1; j < n; j++) {
            rowSum[j] = rowSum[j - 1] + rowSum[0] + m * j * m;
        }
        colSum[0] = (1 + 1 + (n - 1) * m) * n / 2;
        for (int j = 1; j < m; j++) {
            colSum[j] = colSum[j - 1] + colSum[0] + j * n;
        }
        // 行判断
        for (int i = n - 1; i > 0; i--) {
            int a = rowSum[i - 1];
            int b = rowSum[n - 1] - rowSum[i - 1];
            int temp = Math.abs(a - b);
            if (temp < min) {
                min = temp;
                flag = 0;
                num = i + 1;
            }
        }
        // 列判断
        for (int i = m - 1; i > 0; i--) {
            int a = colSum[i - 1];
            int b = colSum[m - 1] - colSum[i - 1];
            int temp = Math.abs(a - b);
            if (temp < min) {
                min = temp;
                flag = 1;
                num = i + 1;
            }
        }
    }

}
