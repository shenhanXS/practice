package hot_100;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author Shenhan
 * @create 2021-05-14-10:50
 */
public class test_5_longestPalindrome {

    String maxLenSub = "";

    public static void main(String[] args) {
        test_5_longestPalindrome test_5 = new test_5_longestPalindrome();
        String sub = test_5.longestPalindrome("accgbdfdsf");
        System.out.println(sub);

    }

    public String longestPalindrome(String s) {

        //中心扩散法 时间复杂度o(n^2)
        //回文串长度为奇数时，中心只有一个字符，回文串长度为偶数时，中心就是两个字符,所以两种都要判断
        //对字符串进行遍历，遍历到的每一个字符都作为中心进行考虑
        for (int i = 0; i < s.length()-maxLenSub.length()/2; i++) {
            check(s, i, i);
            check(s, i, i+1);
        }
        return maxLenSub;
    }
    public void check(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if (maxLenSub.length() >= right-left-1){
            return ;
        }
        maxLenSub =  s.substring(left+1,right);
    }

        /*
        暴力 时间复杂度o(n^3)
        String maxLenSub = "";
        for (int i = 0; i < s.length()-maxLenSub.length(); i++) {
            for (int j = i+maxLenSub.length()+1; j < s.length()+1; j++) {
                if (check(s.substring(i, j))){
                    maxLenSub = s.substring(i, j);
                }
            }
        }
        return maxLenSub;
    }

    public boolean check(String s){
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
         */


}
