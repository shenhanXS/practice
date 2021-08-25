package ali.test20210820.test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-25-17:10
 */
public class Solution {

    List<List<Integer>> list = new ArrayList<>();
    int[] position;
    int max = 1;

    public void f(int a, int b){
        int aPath = position[a];
        int bPath = position[b];
        if(aPath == bPath){
            System.out.println(max - aPath);
        }else {
            list.get(bPath).addAll(list.get(aPath));
            max = Math.max(max, list.get(b).size());
            for(int i : list.get(aPath)) {
                position[i] = bPath;
            }
        }
    }

    public  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        position = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            position[i] = i;
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < b)
                f(a, b);
            else
                f(b, a);
        }
        for(int i = 1; i <= n; i++){
            System.out.print(position[i]);
            if(i != n) {
                System.out.print(" ");
            }
        }
    }
}
