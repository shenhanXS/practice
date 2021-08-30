package JianZhiOffer.Offer_49;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 1也是丑数
 *
 * @author Shenhan
 * @create 2021-08-30-17:07
 */
public class Solution {

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int temp = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            if (temp == ugly[p2] * 2) p2++;
            if (temp == ugly[p3] * 3) p3++;
            if (temp == ugly[p5] * 5) p5++;
            ugly[i] = temp;
        }
        return ugly[n - 1];
    }

}
