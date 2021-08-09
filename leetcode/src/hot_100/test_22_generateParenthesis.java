package hot_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * @author Shenhan
 * @create 2021-05-31-8:32
 */
public class test_22_generateParenthesis {

    List<String> result = new ArrayList<>();


    public static void main(String[] args) {

        test_22_generateParenthesis test_22 = new test_22_generateParenthesis();
        test_22.generateParenthesis(3);
        System.out.println(test_22.result);

    }

    // 使用StringBuffer的append方法进行字符串拼接，效率比String的+高得多
    // 为不影响后续递归执行，每次append后记得删除添加的元素
    public List<String> generateParenthesis(int n) {
        StringBuffer temp = new StringBuffer();
        dfs(0, n, temp);
        return result;
    }
    // temp中待解决的左括号数量left， 余下可用左括号数量total，临时的拼接结果temp
    public void dfs(int left, int total, StringBuffer temp) {
        if (total == 0) {
            if (left == 0) {
                result.add(temp.toString());
            } else {
                dfs(left - 1, total, temp.append(")"));
                temp.deleteCharAt(temp.length()-1);
            }
        } else {
            dfs(left + 1, total - 1, temp.append("("));
            temp.deleteCharAt(temp.length()-1);
            if (left != 0) {
                dfs(left - 1, total, temp.append(")"));
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    /* String的+拼接方法
    public List<String> generateParenthesis(int n) {
        String temp = "";
        dfs(0, n, temp);
        return result;
    }

    // temp中待解决的左括号数量left， 余下可用左括号数量total，临时的拼接结果temp
    public void dfs(int left, int total, String temp) {
        if (total == 0) {
            if (left == 0) {
                result.add(temp);
            } else {
                dfs(left - 1, total, temp + ")");
            }
        } else {
            dfs(left + 1, total - 1, temp + "(");
            if (left != 0) {
                dfs(left - 1, total, temp + ")");
            }
        }
    }

     */


    /* 原始思路
    public List<String> generateParenthesis(int n) {

        StringBuffer temp = new StringBuffer();
        dfs(0, n, temp);
        return result;
    }

    // temp中待解决的左括号数量left， 余下可用左括号数量total，临时的拼接结果temp
    public void dfs(int left, int total, StringBuffer temp) {
        //每次执行添加操作后递归执行dfs，然后删掉刚才添加的小括号，保证不会有累赘括号
        if (total == 0) {
            if (left == 0) {
                result.add(temp.toString());
            } else {
                for (int i = 0; i < left; i++) {
                    temp.append(")");
                }
                result.add(temp.toString());
                for (int i = 0; i < left; i++) {
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        } else {
            if (left == 0) {
                temp.append("(");
                dfs(left + 1, total - 1, temp);
                temp.deleteCharAt(temp.length() - 1);
            } else {
                for (int i = 0; i < 2; i++) {
                    if (i == 0) {
                        temp.append("(");
                        dfs(left + 1, total - 1, temp);
                        temp.deleteCharAt(temp.length() - 1);
                    } else {
                        temp.append(")");
                        dfs(left - 1, total, temp);
                        temp.deleteCharAt(temp.length() - 1);
                    }
                }
            }
        }
    }

     */

}
