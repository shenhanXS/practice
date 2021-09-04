package dailyPractice.test_354_maxEnvelopes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Shenhan
 * @create 2021-09-02-20:57
 */
public class Solution_354 {

    public static void main(String[] args) {

        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        Solution_354 solution_354 = new Solution_354();
        solution_354.maxEnvelopes(envelopes);
    }
    public int maxEnvelopes(int[][] envelopes) {
        // todo
        return 0;
    }


    /*
    // dfs超时
    int result = 0;
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        add(envelopes, 0, 0);
        return result;
    }
    public void add(int[][] envelope, int i, int res) {
        int length = envelope[i][0];
        int width = envelope[i][1];
        for (int j = i; j < envelope.length; j++) {
            if (res == 0) {
                add(envelope, j, res + 1);
            }
            int l = envelope[j][0];
            int w = envelope[j][1];
            if (l > length && w > width) {
                add(envelope, j, res + 1);
            }
        }
        result = Math.max(res, result);
    }
     */

}
