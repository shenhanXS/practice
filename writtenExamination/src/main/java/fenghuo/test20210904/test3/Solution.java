package fenghuo.test20210904.test3;

import org.junit.Test;

import java.util.*;

/**
 * @author Shenhan
 * @create 2021-09-04-19:34
 */
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int m = sc.nextInt();
        int flag = 1;
        int index = 0;
        int len = 1;
        while (true) {
            if (flag == 1) {
                if (len == m) {
                    list.remove(index);
                    if (list.size() == 1){
                        System.out.println(list.get(0));
                        break;
                    }
                    if (index == list.size()) {
                        flag = 0;
                        index--;
                        len = 1;
                    } else {
                        len = 1;
                    }
                    continue;
                }
                if (index + 1 == list.size()) {
                    index--;
                    len++;
                    flag = 0;
                }else {
                    index++;
                    len++;
                }

            }else {
                if (len == m) {
                    list.remove(index);
                    if (list.size() == 1) {
                        System.out.println(list.get(0));
                        break;
                    }
                    if (index == 0) {
                        flag = 1;
                        len = 1;
                    }else {
                        index--;
                        len = 1;
                    }
                    continue;
                }
                if (index == 0) {
                    index++;
                    len++;
                    flag = 1;
                }else {
                    index--;
                    len++;
                }
            }
        }
    }



}
