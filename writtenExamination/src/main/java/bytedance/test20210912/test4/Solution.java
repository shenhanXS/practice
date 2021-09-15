package bytedance.test20210912.test4;

import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Shenhan
 * @create 2021-09-15-11:29
 */
public class Solution {

    public int f(int[] nums) {
        int sum = 0;
        int ans = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int z : nums) {
            if (sum + z >= 0) {
                ans++;
                sum += z;
                if (z < 0) que.offer(z);
            } else {
                if (que.size() > 0 && z > que.peek()) {
                    sum -= que.peek();
                    sum += z;
                    que.poll();
                    que.offer(z);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {1, -1, 4, -4, 1, -3, 1, -3};
        System.out.println(f(nums));
    }
}
