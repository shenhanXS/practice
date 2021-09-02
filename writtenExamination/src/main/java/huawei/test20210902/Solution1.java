package huawei.test20210902;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你两个数组，A,B。从数组A选择一个数A[i],从数组B选择一个数B[j]，要求输出k个使得A[i]+B[j]的和最小的组合，
 * 若有相同的值，则A[i]小的排前面。
 * 比如A=[10,5,30],B=[10,15,20]，k=3。
 * 则输出
 * 5，10;
 * 5，15;
 * 10，10
 *
 * @author Shenhan
 * @create 2021-09-02-15:03
 */
public class Solution1 {

    static List<List<Integer>> res = new ArrayList<>();
    static List<List<Integer>> lists = new ArrayList<>();
    static int[] a;
    static int[] b;

    public static void main(String[] args) {

        a = new int[]{10,5,30};
        b = new int[]{10,15,20};
        int k = 9;
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i = 0; i < a.length; i++) {
            lists.add(Arrays.asList(a[i] + b[0], i, 0));
        }
        for (int i = 0; i < k; i++) {
            getNextMinSum(k);
        }
        for (List<Integer> re : res) {
            System.out.print(re.get(0) + " ");
            System.out.println(re.get(1));
        }

    }
    public static void getNextMinSum(int k) {
        int i = lists.get(0).get(1);
        int j = lists.get(0).get(2);
        res.add(Arrays.asList(a[i], b[j]));
        if (res.size() == k) return;
        lists.remove(0);
        if (j + 1 < b.length) {
            int sum = a[i] + b[j + 1];
            lists.add(Arrays.asList(sum, i, j + 1));
            lists.sort(Comparator.comparingInt((List<Integer> list) -> list.get(0)).thenComparingInt(list -> list.get(1)));
            lists = lists.stream().sorted(Comparator.comparingInt((List<Integer> list) -> list.get(0)).thenComparingInt(list -> list.get(1))).collect(Collectors.toList());
        }
    }

}
