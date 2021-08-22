package PDD.test20210808;

/**
 * @author Shenhan
 * @create 2021-08-08-19:40
 */
public class test_1 {

    public static void main(String[] args) {
        test_1 test_1 = new test_1();
        int[][] nums = {{1,1,1}, {1,1,2}, {3,4,5}};
        int[] result = test_1.getNumber(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] getNumber(int[][] nums){
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int num = getNum(nums[i]);
            result[i] = num;
        }
        return result;
    }
    public int getNum(int[] nums){
        int result = 0;
        int x = nums[0], y = nums[1], r = nums[2];
        double zeroLength = Math.sqrt(x*x + y*y);
        if (r > zeroLength) {
                return 4;
        }else if (r == zeroLength){
            if (x == 0 || y == 0){
                return 2;
            }
            return 3;
        }else {
            if (r > Math.abs(x)){
                result += 2;
            }else if (r == Math.abs(x)){
                result++;
            }
            if (r > Math.abs(y)){
                result += 2;
            }else if (r == Math.abs(y)){
                result++;
            }
            return result;
        }
    }
}
