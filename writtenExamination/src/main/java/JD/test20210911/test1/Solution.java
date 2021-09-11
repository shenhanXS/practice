package JD.test20210911.test1;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-09-11-20:32
 */
public class Solution {

    static Map<Character, Integer> map;
    static int m;
    static int x;
    static int y;
    static int z;
    static int flag;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        z = sc.nextInt();
        int index = 1;
        char first = 'a';
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            char[] chars = s.toCharArray();

            if (flag) {
                first = chars[0];
                flag = false;
            }
            for (char c : chars) {
                map.put(c, index++);
            }
        }
        String str = sc.next();
        char[] chars = str.toCharArray();
        getCost(first, chars[0]);
        for (int i = 0; i < chars.length - 1; i++) {
            getCost(chars[i], chars[i + 1]);
        }
        System.out.println(res);
    }

    static public void getCost(char start, char end) {
        if (start == end) {
            res += z;
        }
        int index1 = map.get(start);
        int index2 = map.get(end);
        int row1 = index1 / m;
        int row2 = index2 / m;
        int col1 = index1 % m;
        int col2 = index2 % m;
        if (row1 == row2) {
            res += (col2 - col1) * x + z;
        }else {
//            res +=
        }


    }

}
