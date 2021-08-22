package PDD.test20210808;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shenhan
 * @create 2021-08-08-19:12
 */
public class test_4 {

    List<Integer> list = new ArrayList<>();
    int result = 0;

    public static void main(String[] args) {
        test_4 test_4 = new test_4();
        int[] nums = {1,2,2,3};
        int n = 4, m = 1;
        System.out.println(test_4.getResolve(n, m, nums));
    }

    public int getResolve(int n, int m, int[] nums) {
        Arrays.sort(nums);
        int[] tag = new int[nums.length];
        for (int i = 0; i < tag.length; i++) {
            tag[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            tag[i] = 0;
            order(m, nums, tag);
            list.remove(list.size() - 1);
            tag[i] = 1;
        }
        return result;
    }
    public void order(int m, int[] nums, int[] tag){
        for (int i = 0; i < nums.length; i++) {
            if (tag[i] == 1){
                int flag = nums[i] - list.get(list.size() - 1);
                if (flag < 0){
                    if ((flag + m) >= 0) {
                        list.add(nums[i]);
                        tag[i] = 0;
                        order(m, nums, tag);
                        list.remove(list.size() - 1);
                        tag[i] = 1;
                    }
                }else {
                    list.add(nums[i]);
                    tag[i] = 0;
                    order(m, nums, tag);
                    list.remove(list.size() - 1);
                    tag[i] = 1;
                }
            }
            if (i == nums.length - 1 && list.size() == nums.length){
                result++;
            }
        }
    }
}
