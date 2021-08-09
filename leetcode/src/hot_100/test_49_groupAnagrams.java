package hot_100;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @author Shenhan
 * @create 2021-06-20-14:57
 */
public class test_49_groupAnagrams {


    // 官方解法一 , 排序
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = hashMap.getOrDefault(s, new ArrayList<String>());
            list.add(str);
            hashMap.put(s, list);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }

}
