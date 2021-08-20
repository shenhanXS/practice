package hot_100.test_56_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 *
 * @author Shenhan
 * @create 2021-06-23-10:19
 */
public class Solution_56 {

    public static void main(String[] args) {

        Solution_56 test_56 = new Solution_56();

    }

    // 官方解法 排序
    public int[][] merge(int[][] intervals) {

        // 这一段排序值得学习
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left){
                res.add(new int[]{left, right});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }
        }
        return res.toArray(new int[0][]);
    }


}
