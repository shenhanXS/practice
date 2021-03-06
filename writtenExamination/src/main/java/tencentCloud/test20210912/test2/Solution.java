package tencentCloud.test20210912.test2;

import org.junit.Test;

import java.util.regex.Pattern;

/**
 * leetcode 10. 正则表达式匹配 https://leetcode-cn.com/problems/regular-expression-matching/
 *
 * @author Shenhan
 * @create 2021-09-12-19:41
 */
public class Solution {

    @Test
    public void test() {
        String s = "mississppi";
        String exp = "mis*is*p*.";
        System.out.println(isMatch(s, exp));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


}
