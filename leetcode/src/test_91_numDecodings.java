
/**
 * 解码方法
 *
 * 思路：假设一个字符串有n种解码方式 ，然后在该字符串后面再加上一个数字，那么会有多少种解码方式呢
 *      设置三个形参，原字符串解码方式 n 个，原字符串有 m1 个以1为结尾的解码方式，原字符串有 m2 个以2为结尾的解码方式
 *      针对新加的数字进行情况分析：
             1、新加的数字为 0，考虑到原字符串结尾的1或者2都能与新加的0进行拼接，而且解码方式上也必须进行拼接，
                   那么n = m1>m2 ? m1 : m2 ，m1和 m2置为 0
             2、新加的数字为 1，考虑到原字符串结尾的1或者2都能与新加的1进行拼接，解码方式上可以拼接也可以不拼接，
                   那么 n = m1>m2 ? n+m1 : n+m2 ，m1则为原先的 n，m2置为 0
             3、新加的数字为 2，n取值思路同上，m1置为 0，m2则为原先的 n
             4、新加的数字为 3-6，n取值思路同上，m1和 m2置为 0
             5、新加的数字为 7-9 ，考虑到只有原字符串以1为结尾时才能进行拼接，
                    那么 n = m1>0 ? n+m1 : n ，m1和 m2置为 0
            每次处理完后对 n 进行一个判断，如果 n 为 0，则直接退出循环，返回 n 值 ，减少不必要的操作
 *
 * @author Shenhan
 * @create 2021-04-21-10:57
 */
public class test_91_numDecodings {

    public static void main(String[] args) {
        String s = "11022";
        int i = numDecodings(s);
        System.out.println(i);
    }

    public static int numDecodings(String s) {

        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        int n = 0, m1 = 0, m2 = 0;
        int temp;
        char val;
        //针对s的第一位进行一个初始化
        if (chars[0] == '1'){
            n = 1;
            m1 = 1;
            m2 = 0;
        }else if (chars[0] == '2'){
            n = 1;
            m1 = 0;
            m2 = 1;
        }else {
            n = 1;
            m1 = 0;
            m2 = 0;
        }
        //开始循环，从s的第二位开始
        for (int i = 1; i < s.length(); i++) {
            val = chars[i];
            if (val == '0'){
                n = m1>m2 ? m1 : m2;
                m1 = 0;
                m2 = 0;
            }else if (val == '1'){
                temp = n;
                n = m1>m2 ? n+m1 : n+m2;
                m1 = temp;
                m2 = 0;
            }else if (val == '2'){
                temp = n;
                n = m1>m2 ? n+m1 : n+m2;
                m1 = 0;
                m2 = temp;
            }else if (val <= '6'){
                n = m1>m2 ? n+m1 : n+m2;
                m1 = 0;
                m2 = 0;
            }else{
                n = m1>0 ? n+m1 : n;
                m1 = 0;
                m2 = 0;
            }

            if (n == 0){
                return 0;
            }
        }

        return n;
    }

}
