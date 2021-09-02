package huawei.test20210901.test2;

import org.junit.Test;

import java.util.*;

/**
 * @author Shenhan
 * @create 2021-09-01-19:05
 */
public class Solution {

    static HashMap<String, List<String>> classMap = new HashMap<>(); // 存放子概念
    static HashMap<String, SortedSet<String>> instanceMap = new HashMap<>(); // 存放实例

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String enter = sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            if (s1[1] == "subClassOf") {
                if (classMap.get(s1[2]) == null) {
                    classMap.put(s1[2], Arrays.asList(s1[0]));
                }
                classMap.put(s1[0], new ArrayList<>());
            }else {
                SortedSet<String> set = instanceMap.get(s1[2]);
                if (set == null) {
                    set = new TreeSet(new Comparator() {
                        @Override
                        public int compare(Object o1, Object o2) {
                            return ((String) o1).compareTo((String) o2);
                        }
                    });
                }
                set.add(s1[0]);
                instanceMap.put(s1[2], set);
            }
        }
        String s = sc.next();
        SortedSet<String> res = get(s);
        if (res.size() == 0) {
            System.out.println("empty");
        }else {
            for (String re : res) {
                System.out.println(re);
            }
        }
    }
    public static SortedSet<String> get(String s) {
        SortedSet<String> res = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String) o1).compareTo((String) o2);
            }
        });
        // 子概念classList
        List<String> classList = classMap.get(s);
        // 该概念直属的所有实例set
        SortedSet<String> set = instanceMap.get(s);
        if (set != null) {
            res.addAll(set);
        }
        // 从子概念中拿获取实例
        if (classList != null) {
            for (int i = 0; i < classList.size(); i++) {
                String s1 = classList.get(i);
                SortedSet<String> tempSet = get(s1);
                res.addAll(tempSet);
            }
        }
        return res;
    }

}
