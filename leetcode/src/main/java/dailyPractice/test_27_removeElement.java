package dailyPractice;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 * @author Shenhan
 * @create 2021-04-19-20:47
 */
public class test_27_removeElement {

    public static void main(String[] args) {
        int[] nums = {0,1,3,4,4,3,3};
        int i = removeElement(nums, 3);
        System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {
        //使用双指针
        int validIndex = nums.length - 1; //指向最后一个有效位置
        for (int i = validIndex; i >= 0; i--) {
            if (nums[i] == val){
                nums[i] = nums[validIndex];
                validIndex--;
            }
        }
        return validIndex + 1;

        // 2021/4/19
//        int num = 0;
//        int temp = 0;
//        if(nums.length == 0){
//            return 0;
//        }else {
//            for (int i = 0; i < nums.length; i++) {
//                if (nums[i]==val){
//                    num++;
//                }
//            }
//            for(int i = 0; i+num < nums.length;i++){
//                if(nums[i] == val){
//                    for(int j=i+1; j<nums.length;j++){
//                        if(nums[j] != val){
//                            temp = nums[i];
//                            nums[i] = nums[j];
//                            nums[j] = temp;
//                            break;
//                        }
//                    }
//                }
//            }
//            return nums.length-num;
//        }

    }

}


