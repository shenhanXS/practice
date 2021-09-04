package xiaoHongShu.test20210904.test1;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author Shenhan
 * @create 2021-09-04-10:58
 */
public class Solution {


    public int maxSumSubmatrix(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        // 固定的是否为右边界
        boolean isRight = n > m;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= (isRight ? m : n); i++) {
            for (int j = i; j <= (isRight ? m : n); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++) {
                    int a = isRight ? sum[j][fixed] - sum[i - 1][fixed] : sum[fixed][j] - sum[fixed][i - 1];
                    Integer b = ts.ceiling(a - k);
                    if (b != null) {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }

    /*
    static int[][] sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i-1][j-1] - sum[i-1][j-1];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int p = i; p <= n; p++) {
                    for (int q = j; q <= n; q++) {
                        int cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];
                        res = Math.max(res, cur);
                    }
                }
            }
        }
        System.out.println(res);
    }
     */




}


