import java.util.Arrays;

/**
 * 给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * @author Shenhan
 * @create 2021-05-08-16:24
 */
public class test_1723_minimumTimeRequired {

    public static void main(String[] args) {

        int[] jobs = {9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202};
        int k = 9;
        int i = minimumTimeRequired(jobs, k);
        System.out.println(i);

    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int len = jobs.length;

        if (len == k){
            return jobs[len-1];
        }

        int[] sum = new int[len];
        if (k == 2){
            for (int i = 1; i < len; i++) {
                sum[i] = sum[i-1] + jobs[i-1];
            }
        }

        int[] distribution = new int[k];
        int flag = len -1;
        for (int i = len-1; i >= 0; i--) {
            if (k == 2){
                if (distribution[1] + jobs[i] <= sum[i]){
                    distribution[1] += jobs[i];
                    Arrays.sort(distribution);
                }else {
                    distribution[0] += jobs[i];
                    Arrays.sort(distribution);
                }
            }else {
                distribution[0] += jobs[i];
                Arrays.sort(distribution);
            }
        }

        return distribution[k-1];
    }

}
