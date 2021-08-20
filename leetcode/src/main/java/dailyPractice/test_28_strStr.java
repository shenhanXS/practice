package dailyPractice;

/**
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。
 * 如果不存在，则返回  -1 。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。
 *
 * indexOf()方法直接返回结果
 *
 * @author Shenhan
 * @create 2021-04-21-9:56
 */
public class test_28_strStr {

    public static void main(String[] args) {
        String haystack = "";
        String needle = "a";
        int i = strStr(haystack, needle);
        System.out.println(i);

        int i1 = haystack.indexOf(needle);

    }

    public static int strStr(String haystack, String needle) {
        // 暴力求解
        if (needle.length() == 0){
            return 0;
        }else if (haystack.length() < needle.length()){
            return -1;
        }else {
            int h_len = haystack.length();
            int n_len = needle.length();
            for (int i=0; i <= h_len-n_len; i++) {
                if (haystack.substring(i, i+n_len).equals(needle)){
                    return i;
                }
            }
            return -1;
        }

        // 直接使用indexOf()
//        return haystack.indexOf(needle);

        // KMP
//        if (needle.isEmpty()) return 0;
//
//        // 分别读取原串和匹配串的长度
//        int n = haystack.length(), m = needle.length();
//        // 原串和匹配串前面都加空格，使其下标从 1 开始
//        haystack = " " + haystack;
//        needle = " " + needle;
//
//        char[] s = haystack.toCharArray();
//        char[] p = needle.toCharArray();
//
//        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
//        int[] next = new int[m + 1];
//        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
//        for (int i = 2, j = 0; i <= m; i++) {
//            // 匹配不成功的话，j = next(j)
//            while (j > 0 && p[i] != p[j + 1]) j = next[j];
//            // 匹配成功的话，先让 j++
//            if (p[i] == p[j + 1]) j++;
//            // 更新 next[i]，结束本次循环，i++
//            next[i] = j;
//        }
//
//        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
//        for (int i = 1, j = 0; i <= n; i++) {
//            // 匹配不成功 j = next(j)
//            while (j > 0 && s[i] != p[j + 1]) j = next[j];
//            // 匹配成功的话，先让 j++，结束本次循环后 i++
//            if (s[i] == p[j + 1]) j++;
//            // 整一段匹配成功，直接返回下标
//            if (j == m) return i - m;
//        }
//
//        return -1;


    }
}
