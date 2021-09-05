package fenghuo.test20210904.test2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-05-14:45
 */
public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
    }

    @Test
    public void test() {
        //输入部分忽略
        //数组am是已从大到小排序好的部队人数数组
        int[] am = {18,6,5,2};
        //n 是部队数
        int n = am.length;
        //大军队下标
        int res = 0;
        //最多隐藏部队数为n/2+n%2
        for (int i = 0; i < n / 2 + n % 2; i++) {
        //因为最多藏一半，所以从数组中间取最大 小军队
            if (am[res] / 3 >= am[n / 2 + i])
            //如果符合隐藏条件，大军队下标即为隐藏部队数
                res++;
        }
        System.out.println(n - res);
    }

}
