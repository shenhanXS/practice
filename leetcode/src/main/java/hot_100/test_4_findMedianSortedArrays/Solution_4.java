package hot_100.test_4_findMedianSortedArrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * @author Shenhan
 * @create 2021-06-02-11:14
 */
public class Solution_4 {

    public static void main(String[] args) {

        int[] nums1 = {2};
        int[] nums2 = {};
        Solution_4 test_4 = new Solution_4();
        double result = test_4.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);


    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        int extra_middle_index = len/2;
        int middle_index = extra_middle_index + 1;
        int result_num = 2*extra_middle_index==len ? 2:1;
        int middle=0, extra_middle=0;
        int flag;
        int i=0,j=0;
        while (i<nums1.length && j<nums2.length){
            if (nums1[i] <= nums2[j]){
                i++;
                flag = 1;
            }else {
                j++;
                flag = 2;
            }
            middle_index--;
            extra_middle_index--;
            if (extra_middle_index == 0){
                extra_middle = flag==1 ? nums1[i-1]:nums2[j-1];
            }
            if (middle_index == 0){
                middle = flag==1 ? nums1[i-1]:nums2[j-1];
                return result_num==1 ? middle:Double.valueOf(middle+extra_middle)/2;
            }
        }
        if (i == nums1.length){
            while (j < nums2.length){
                j++;
                middle_index--;
                extra_middle_index--;
                if (extra_middle_index == 0){
                    extra_middle = nums2[j-1];
                }
                if (middle_index == 0){
                    middle = nums2[j-1];
                    return result_num==1 ? middle:Double.valueOf(middle+extra_middle)/2;
                }
            }
        }else {
            while (i < nums1.length){
                i++;
                middle_index--;
                extra_middle_index--;
                if (extra_middle_index == 0){
                    extra_middle = nums1[i-1];
                }
                if (middle_index == 0){
                    middle = nums1[i-1];
                    return result_num==1 ? middle:Double.valueOf(middle+extra_middle)/2;
                }
            }
        }

        return middle;
    }
}
