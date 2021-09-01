package PDD.test20210831.test2;

import org.junit.Test;

import java.util.logging.Level;

/**
 * @author Shenhan
 * @create 2021-08-31-20:45
 */
public class Solution {

    public static void main(String[] args) {
        String s = getMinSort("dcba");
        System.out.println(s);
    }

    public static boolean compare(String s1, String s2) {

        return false;
    }
    public static String getMinSort(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) > s.charAt(len - i - 1)) {
                s = s.substring(len - i - 1, len - i) + s.substring(i + 1, len - i - 1) + s.substring(i, i + 1);
            }
        }
        return s;
    }
    

}
