package xiaoHongShu.test2021.test1;

import xiaoHongShu.test2021.test2.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-21-11:26
 */
public class Solution {

    int white, black;
    List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Solution solution = new Solution();
        solution.white = n / 2;
        solution.black = n / 2;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                List<Integer> temp = new ArrayList<>();
                int energyWhite = sc.nextInt();
                int energyBlack = sc.nextInt();
                temp.add(Math.abs(energyBlack - energyWhite));
                temp.add(energyWhite < energyBlack ? 0 : 1);
                temp.add(energyWhite);
                temp.add(energyBlack);
                solution.list.add(temp);
            }else if (x == 1) {
                solution.white--;
            }else {
                solution.black--;
            }
        }

    }
    public void minEnergy(){

    }
}
