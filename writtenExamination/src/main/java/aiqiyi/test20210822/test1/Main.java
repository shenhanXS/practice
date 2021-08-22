package aiqiyi.test20210822.test1;

import java.util.Scanner;

/**
 * @author Shenhan
 * @create 2021-08-22-15:55
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        int res = getMaxAmplitude(nums);
        System.out.println(res);
    }

    public static int getMaxAmplitude(int[] nums) {
        boolean flag = true;
        int min = nums[0], max = nums[0];
        int maxAmplitude = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (nums[i] > nums[i - 1]) {
                if (!flag){
                    flag = true;
                }
                max = nums[i];
                maxAmplitude = Math.max(max - min,maxAmplitude);
            }else{
                if (flag) {
                    flag = false;
                }
                min = nums[i];
                maxAmplitude = Math.max(max - min, maxAmplitude);
            }
        }
        return maxAmplitude;
    }
}
