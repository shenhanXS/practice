package hot_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * @author Shenhan
 * @create 2021-05-24-8:26
 */
public class test_17_letterCombinations {

    private HashMap<Integer, List<String>> map = new HashMap<>();
    List<String> result = new ArrayList<>();
    String[] ant = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static void main(String[] args) {

        test_17_letterCombinations test_17 = new test_17_letterCombinations();
        String digits = "2";
        List<String> list = test_17.letterCombinations(digits);

        System.out.println(list);

    }

    /* 使用String定义然后使用加号 + 进行字符拼接相比StringBuffer可以少写一行delete，
        但是Srting的+的效率相比StringBuffer的append效率低太多
    public List<String> letterCombinations(String digits) {
        //dfs
        if(digits.length() == 0) return new ArrayList<>();
        String ans = "";
        dfs(digits, 0, ans);
        return result;
    }
    public void dfs(String digits, int temp, String ans){
        if(temp == digits.length()) result.add(ans);
        else{
            int num = digits.charAt(temp) - '0' - 2;
            for(int i = 0; i < ant[num].length(); i++){
                dfs(digits, temp + 1, ans+ant[num].charAt(i));
            }
        }
    }
     */

    public List<String> letterCombinations(String digits) {
        //dfs
        if(digits.length() == 0) return new ArrayList<String>();
        StringBuffer ans = new StringBuffer();
        dfs(digits, 0, ans);
        return result;
    }

    public void dfs(String digits, int temp, StringBuffer ans){
        if(temp == digits.length()) result.add(ans.toString());
        else{
            int num = digits.charAt(temp) - '0' - 2;
            for(int i = 0; i < ant[num].length(); i++){
                ans.append(ant[num].charAt(i));
                dfs(digits, temp + 1, ans);
                ans.deleteCharAt(temp);
            }
        }
    }

    /*
    public List<String> letterCombinations(String digits) {
        //dp
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        List<String> list = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            list = dp(list, Integer.parseInt(digits.substring(i, i+1)));
        }

        return list;
    }
    public List<String> dp(List<String> list, int num){
        int len = list.size();
        if (len == 0){
            for(String str : map.get(num)){
                list.add(str);
            }
            return list;
        }
        for (int i = 0; i < len; i++) {
            for(String str : map.get(num)){
                list.add(list.get(0)+str);
            }
            list.remove(0);
        }
        return list;
    }
     */

}
