package JD.test20210911.test2;

import java.util.*;

/**
 * @author Shenhan
 * @create 2021-09-11-19:43
 */
public class Solution {

    static List<List<Integer>> openList = new ArrayList<>();
    static List<Set<Integer>> closeList = new ArrayList<>();
    static Set<Integer> res = new HashSet<>();
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        visited = new int[n + 1];
        openList.add(new ArrayList<>());
        closeList.add(new HashSet<>());
        for (int i = 0; i < n; i++) {
            openList.add(new ArrayList<>());
            closeList.add(new HashSet<>());
        }
        for (int i = 1; i < n + 1; i++) {
            int num = sc.nextInt();

            for (int j = 0; j < num; j++) {
                openList.get(i).add(sc.nextInt());
            }

            for (Integer integer : openList.get(i)) {
                closeList.get(integer).add(i);
            }
        }
        for (int i = 0; i < q; i++) {
            int operation = sc.nextInt();
            int num = sc.nextInt();

            Arrays.fill(visited, 0);
            if (operation == 1) {
                open(num);
            }else {
                close(num);
            }
            System.out.println(res.size());
        }
    }
    public static void open(int num) {
        if (visited[num] == 1) return;
        res.add(num);
        visited[num] = 1;
        for (Integer integer : openList.get(num)) {
            open(integer);
        }
    }
    public static void close(int num) {
        if (visited[num] == 1) return;
        res.remove(num);
        visited[num] = 1;
        for (Integer integer : closeList.get(num)) {
            close(integer);
        }
    }


}
