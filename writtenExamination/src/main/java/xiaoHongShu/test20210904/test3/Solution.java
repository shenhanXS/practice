package xiaoHongShu.test20210904.test3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-04-10:24
 */
public class Solution {

    static int[][] weight;
    static int N;


    // i 0 k i
    public static int dfs(int u, int w, int k, int par) {
        int ans = 0;
        for (int v = 1; v <= N; v++) {
            if (v != par && weight[u][v] != 0 && w + weight[u][v] <= k) {
                ans++;
                ans += dfs(v, w + weight[u][v], k, u);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        weight = new int[N + 1][N + 1];
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; ) {
            int a = Integer.parseInt(s1[i++]);
            int b = Integer.parseInt(s1[i++]);
            int c = Integer.parseInt(s1[i++]);
            weight[a][b] = weight[b][a] = c;
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += dfs(i, 0, k, i);
        }
        System.out.println(ans / 2);
    }


}
