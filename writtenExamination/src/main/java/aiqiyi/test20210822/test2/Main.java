package aiqiyi.test20210822.test2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-22-15:55
 */
public class Main {

    static List<List<String>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            queen(n, i);
        }
        for (List<String> strings : list) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
    public static void queen(int n, int i) {
        List<List<Integer>> queenPosition = new ArrayList<>();
        queenPosition.add(Arrays.asList(0, i));
        for (int j = 1; j < n; j++) {
            for (int k = 0; k < n; k++) {  // 00100  00010
                boolean flag = true;
                for (int l = 0; l < queenPosition.size(); l++) {
                    int x = queenPosition.get(l).get(0), y = queenPosition.get(l).get(1);
                    if (j == x || k == y || Math.abs(x - j) == Math.abs(y - k)) {
                        flag = false;
                    }
                }
                if (flag) {
                    queenPosition.add(Arrays.asList(j, k));
                }
            }
        }
        if (queenPosition.size() == n) {
            ArrayList<String> res = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                List<Integer> temp = queenPosition.get(j);
                int y = temp.get(1);
                String s = "";
                for (int k = 0; k < n; k++) {
                    if (k == y) {
                        s += "Q";
                    }else {
                        s += ".";
                    }
                }
                res.add(s);
            }
            list.add(res);
        }
    }


}
