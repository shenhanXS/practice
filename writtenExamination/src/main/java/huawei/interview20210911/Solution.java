package huawei.interview20210911;

import org.junit.Test;

/**
 * @author Shenhan
 * @create 2021-09-11-15:44
 */
public class Solution {

    public int getNum(int[] nums, int k) {
        int index = nums[0];

        for (int i = 0; i < nums.length;) {
            if (nums[i] != index) {
                k--;
                if (k == 0) {
                    return index;
                }
            }else {
                i++;
            }
            index++;
        }

        return index + k - 1;
    }

    @Test
    public void test() {
        int[] nums = {1,2,4};
        System.out.println(getNum(nums, 3));
        System.out.println(getNum(nums, 1));
        System.out.println(getNum(nums, 5));
    }

}
