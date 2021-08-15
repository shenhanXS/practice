package meituan.Test2021.test2;

/**
 * @author Shenhan
 * @create 2021-08-15-10:22
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab";
        System.out.println(solution.longestPalindrome(s));
    }

    public int longestPalindrome(String s) {
        int minLength = s.length() - 1;
        for (int i = s.length() - 1; i >= s.length()/2 - 1; i--) {
            int length1 = check(s, i, i);
            int length2 = check(s, i, i+1);
            if (length1 / 2 + i + 1 == s.length()){
                minLength = Math.min(s.length() - length1, minLength);
            }
            if (length2 / 2 + i + 1 == s.length()) {
                minLength = Math.min(s.length() - length2, minLength);
            }
        }
        return minLength;
    }
    public int check(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

}
