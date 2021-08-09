/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * @author Shenhan
 * @create 2021-04-28-16:45
 */
public class test_633_judgeSquareSum {

    public static void main(String[] args) {

        boolean b = judgeSquareSum(3);
        System.out.println(b);

    }

    public static boolean judgeSquareSum(int c) {

        int max = (int)Math.sqrt(c);
        int mid = (int)Math.sqrt(c/2);
        for (int i = max; i >= mid ; i--) {

            int j = (int)Math.sqrt(c - i*i);

            if (i*i + j*j == c){
                return true;
            }
            }
        return false;


    }

}
