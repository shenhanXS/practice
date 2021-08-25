package xiaoHongShu.test20210821.test2;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-21-10:18
 */
public class Main {

    int res = 0;
    int nums = 0;
    int lastNum = 0;
    int[][] p;
    int[][] flag;

    public int getResult(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p = new int[n][n];
        flag = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                if ('.' == s.charAt(j)) {
                    p[i][j] = 1;
                    nums++;
                    if (i == p.length - 1) {
                        lastNum++;
                    }
                }
            }
        }
        flag[0][0] = 1;
        if (p.length == 1) lastNum--;
        walk(0,0, 1, lastNum);
        return res;
    }

    public void walk(int i, int j, int num, int lastNum){
        if (lastNum == 0) {
            if (num == nums) {
                if (i + 1 == p.length) {
                    res++;
                }
                return;
            }
        }else return;
        // 上
        if (i - 1 >= 0 && p[i - 1][j] == 1 && flag[i - 1][j] == 0) {
            flag[i - 1][j] = 1;
            walk(i - 1, j, num + 1, i == p.length-1 ? lastNum - 1 : lastNum);
            flag[i - 1][j] = 0;
        }
        // 下
        if (i + 1 < p.length && p[i + 1][j] == 1 && flag[i + 1][j] == 0) {
            flag[i + 1][j] = 1;
            walk(i + 1, j, num + 1, i == p.length-1 ? lastNum - 1 : lastNum);
            flag[i + 1][j] = 0;
        }
        // 左
        if (j - 1 >= 0 && p[i][j - 1] == 1 && flag[i][j - 1] == 0) {
            flag[i][j - 1] = 1;
            walk(i, j - 1, num + 1, i == p.length-1 ? lastNum - 1 : lastNum);
            flag[i][j - 1] = 0;
        }
        // 右
        if (j + 1 < p.length && p[i][j + 1] == 1 && flag[i][j + 1] == 0) {
            flag[i][j + 1] = 1;
            walk(i, j + 1, num + 1, i == p.length-1 ? lastNum - 1 : lastNum);
            flag[i][j + 1] = 0;
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.getResult());
    }
}
