package dailyPractice;

import java.util.Arrays;

/**
 * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 *
 * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 *
 * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 *
 * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 *
 * @author Shenhan
 * @create 2021-05-09-20:46
 */
public class test_1482_minDays {

    public static void main(String[] args) {

        int[] bloomDay = {7,7,7,7,12,7,7};
        int m = 2, k = 3;
        int i = minDays(bloomDay, m, k);
        System.out.println(i);

    }

    public static int minDays(int[] bloomDay, int m, int k) {

        //二分法
        if (m*k > bloomDay.length){
            return -1;
        }

        int sum = 0; //sum记录共能采集多少束花
        int left = 0,right = 0;
        left = Arrays.stream(bloomDay).min().getAsInt();
        right = Arrays.stream(bloomDay).max().getAsInt();
        while (left < right){
            sum = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i <= bloomDay.length-k;) {
                int j;
                for (j = i; j < i+k; j++) {
                    if (bloomDay[j] <= mid){
                        continue;
                    }else {
                        i = j + 1;
                        break;
                    }
                }

                if (j == i+k){
                    sum++;
                    i += k;
                }
            }

            if (sum >= m){
                right = mid;
            }else {
                left = ++mid;
            }
        }

        return left;

        /*
        //二分法
        if (m*k > bloomDay.length){
            return -1;
        }

        int sum = 0; //sum记录共能采集多少束花
        int left = 0,right = 0;
        int[] maxDay = new int[bloomDay.length-k+1];
        for (int i = 0; i < maxDay.length; i++) {
            for (int j = i; j < i+k; j++) {
                maxDay[i] = Math.max(maxDay[i], bloomDay[j]);
            }
            left = Math.min(left, maxDay[i]);
            right = Math.max(right, maxDay[i]);
        }

        while (left < right){
            sum = 0;
            int mid = (left + right) / 2;

            for (int i = 0; i < maxDay.length;) {
                if (maxDay[i] <= mid){
                    sum++;
                    i += k;
                }else {
                    i++;
                }
            }

            if (sum >= m){
                right = mid;
            }else {
                left = ++mid;
            }
        }

        return left;
        */
    }

}
