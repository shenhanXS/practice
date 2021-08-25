package ali.test20210820.test1;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-25-17:09
 */
public class Solution {

    HashSet<Integer> set = new HashSet<>();
    int[] nums = new int[5];

    public void f(int a, int b, int c, int k){
        if(b == 1) {
            if(!set.contains(a)){
                if(nums[c - 1] < k){
                    set.add(a);
                    nums[c - 1] += 1;
                }
            }
        }else{
            nums[c - 1] -= 1;
        }
    }

    public static void main(String[] args) {
        Solution aa = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            aa.f(a, b, c, k);
            for(int num : aa.nums) {
                System.out.print(num);
                System.out.print(" ");
            }
        }
    }

}
