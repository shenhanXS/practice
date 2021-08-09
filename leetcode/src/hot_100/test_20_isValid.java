package hot_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * @author Shenhan
 * @create 2021-05-26-9:36
 */
public class test_20_isValid {

    public static void main(String[] args) {

        String s = "()[]";
        test_20_isValid test_20 = new test_20_isValid();
        System.out.println(test_20.isValid(s));

    }

    public boolean isValid(String s) {

        // 栈
        Stack<Character> stack = new Stack<>();
        stack.add(')');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' ||
                s.charAt(i) == ']' ||
                s.charAt(i) == '}'){
                if (s.charAt(i) - stack.get(stack.size()-1) == 1 ||
                    s.charAt(i) - stack.get(stack.size()-1) == 2){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                stack.add(s.charAt(i));
            }
        }
        return stack.size()==1;
    }
}
