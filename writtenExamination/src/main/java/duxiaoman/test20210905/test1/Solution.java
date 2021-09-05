package duxiaoman.test20210905.test1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-05-15:25
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextInt();
        }
        Arrays.sort(time);
        if (time[0] + k >= time[n - 1]) {
            System.out.println("1/1");
        }
        int flag = 1;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = flag; j < n; j++) {
                if (time[i] + k >= time[j]) {
                    flag = j;
                    res = res + (j - i);
                    break;
                }
            }
        }
        int num = 1; //记录总可能数
        num = n * (n - 1) / 2;



    }


}
