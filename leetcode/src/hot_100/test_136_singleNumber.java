package hot_100;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * @author Shenhan
 * @create 2021-07-28-16:24
 */
public class test_136_singleNumber {

    // 官方解法 异或
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int num : nums) {
            i ^= num;
        }
        return i;
    }
}
