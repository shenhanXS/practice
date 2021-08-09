package hot_100;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * @author Shenhan
 * @create 2021-04-19-22:39
 */
public class test_1_twoSum {

    public static void main(String[] args) {

        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
//        hashtable.put(6, 1);
//        hashtable.put(5, 3);
//        System.out.println(hashtable);

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {

        //2021/5/6
        /**
         * 根据题意，如果我们使用暴破，会导致时间复杂度为 n^2，这样的代价无疑是很大的。
         *
         * 所以我们很容易想到用哈希表来解决这个问题。
         *
         * 我们遍历到数字 a 时，用 target 减去 a，就会得到 b，若 b 存在于哈希表中，我们就可以直接返回结果了。
         * 若 b 不存在，那么我们需要将 a 存入哈希表，好让后续遍历的数字使用。
         *
         */
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];

        // 2021/4/19 暴力求解
//        int[] result = new int[2];
//
//        for(int i = 0; i < nums.length; i++){
//            for(int j=i+1;j < nums.length; j++){
//                if(nums[i]+nums[j] == target){
//                    result[0] = i;
//                    result[1] = j;
//                    break;
//                }
//            }
//        }
//        return result;
    }

}


