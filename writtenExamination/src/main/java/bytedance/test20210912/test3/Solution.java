package bytedance.test20210912.test3;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-12-10:08
 */
public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] defence;
        int[] attack;

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            defence = new int[n];
            attack = new int[m];

            for (int k = 0; k < n; k++) {
                defence[k] = sc.nextInt();
            }
            for (int k = 0; k < m; k++) {
                attack[k] = sc.nextInt();
            }
            System.out.println(getResult(defence, attack));
        }
    }
    public static boolean getResult(int[] defence, int[] attack) {
        int def = 1;
        int att = 1;
        int defLen = defence.length;
        int attLen = attack.length;
        int index = Math.min(defLen, attLen);

        for (int i = 0; i < index; i++) {
            def *= defence[i];
            att *= attack[i];

            int gcd = gcd(def, att);
            def /= gcd;
            att /= gcd;
        }
        if (index == defLen) {
            if (index != attLen) {
                for (int i = index; i < attLen; i++) {
                    att *= attack[i];
                    int gcd = gcd(def, att);
                    def /= gcd;
                    att /= gcd;
                }
            }
            return att == 1;
        }else {
            if (att == 1){
                return true;
            }
            for (int i = index; i < defLen; i++) {
                def *= defence[i];
                int gcd = gcd(def, att);
                def /= gcd;
                att /= gcd;
                if (att == 1){
                    return true;
                }
            }
        }
        return false;
    }
    public static int gcd(int x, int y) {
        if(y == 0)
            return x;
        else
            return gcd(y,x%y);
    }


}
