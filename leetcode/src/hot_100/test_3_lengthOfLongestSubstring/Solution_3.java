package hot_100.test_3_lengthOfLongestSubstring;

import java.util.HashMap;

/**
 * @author Shenhan
 * @create 2021-05-12-8:53
 */
public class Solution_3 {

    public static void main(String[] args) {

//        HashMap<String, Integer> hashMap = new HashMap<>();
//        hashMap.put("a", 0);
//        hashMap.put("b", 1);
//        hashMap.put("c", 2);
//        hashMap.put("a", 3);
        String s = "acbcaade";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);

    }

    public static int lengthOfLongestSubstring(String s) {

        //滑动窗口
        if (s.length() == 0) return 0;
        int left = 0, max = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))){
                left = Math.max(left, hashMap.get(s.charAt(i))+1);
            }
            hashMap.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

        /*
        if (s.length() == 0 || s.length() == 1){
            return s.length();
        }
        int maxLen = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; s.length() - i > maxLen ;) {
            hashMap.clear();
            hashMap.put(s.substring(i, i+1), i);
            for (int j = i+1; j < s.length(); j++) {
                String sub = s.substring(j, j + 1);
                if (hashMap.containsKey(sub)){
                    maxLen = Math.max(maxLen, j - i);
                    i = hashMap.get(sub) + 1;
                    break;
                }else {
                    hashMap.put(sub, j);
                    if (j+1 == s.length()){
                        maxLen = j-i+1;
                        i++;
                    }
                }
            }

        }
        return maxLen;
         */
    }

}
