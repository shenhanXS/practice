package bytedance.test20210912.test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shenhan
 * @create 2021-09-12-10:41
 */
public class Solution {

    public static void main(String[] args) {
        int n = 4;
//        int a[][] = {{1, 2}, {2, 4}};
        int a[][] = {{1, 2}, {2, 4}, {3, 7}, {4, 6}};
        System.out.println(minMeetingRooms(a));
    }

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i][1]);
        }
        return queue.size();


        /*
        if (intervals == null || intervals.length == 0)
            return 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0;
        int endIdx = 0;
        for (int start : starts) {
            if (start > ends[endIdx]) {
                endIdx++;
            } else {
                count++;
            }
        }
        return count;
         */

    }

}
