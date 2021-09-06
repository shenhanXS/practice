package shopee.test2;

import org.junit.Test;

/**
 * @author Shenhan
 * @create 2021-09-06-20:00
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        String express = "1^0|0|1";
        boolean desired = false;
        System.out.println(s.GetNumOfExpress(express, desired));
    }

    int res = 0;
    public long GetNumOfExpress(String express, boolean desired) {
        if (express.length() == 1) {
            boolean flag = !"0".equals(express);
            return flag == desired ? 1 : 0;
        }
        for (int i = 1; i < express.length(); i += 2) {
            int m = express.charAt(i - 1) - '0';
            int n = express.charAt(i + 1) - '0';
            char c = express.charAt(i);
            int calc = calc(m, n, c);
            // 向左
            spread(i - 2, 2, express, desired, 0, calc);
            // 向右
            spread(i + 2, 2, express, desired, 1, calc);
        }
        return res;
    }
    public void spread(int index, int symbolNum, String express, boolean desired, int source, int temp) {
        if (index < 0 || index >= express.length()) return;
        int i = 0, j = 0;
        if (source == 0) {
            i = express.charAt(index - 1) - '0';
            j = temp;
        } else {
            i = temp;
            j = express.charAt(index + 1) - '0';
        }
        char c = express.charAt(index);
        int calc = calc(i, j, c);
        if (symbolNum == express.length() / 2) {
            boolean flag = !(0 == calc);
            res += flag == desired ? 1 : 0;
        }
        // 向左扩散计算
        if (source == 0) {
            spread(index - 2, symbolNum + 1, express, desired, 0, calc);
        } else {
            // 1|1|1|1
            spread(index - 2 * symbolNum, symbolNum + 1, express, desired, 0, calc);
        }
        // 向右扩散计算
        if (source == 0) {
            spread(index + 2 * symbolNum, symbolNum + 1, express, desired, 1, calc);
        } else {
            spread(index + 2, symbolNum + 1, express, desired, 1, calc);
        }
    }
    public int calc(int i, int j, char c) {
        if (c == '|') {
            return i | j;
        } else if (c == '&') {
            return i & j;
        } else {
            return i ^ j;
        }
    }


}
