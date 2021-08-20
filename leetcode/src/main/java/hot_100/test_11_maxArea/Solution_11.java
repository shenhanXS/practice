package hot_100.test_11_maxArea;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * @author Shenhan
 * @create 2021-05-19-8:24
 */
public class Solution_11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution_11 test = new Solution_11();
        int max = test.maxArea(height);
        System.out.println(max);
    }

    public int maxArea(int[] height) {

        //双指针
        int left = 0;
        int right = height.length-1;
        int max = 0;

        while (left <= right){
            max = height[left] < height[right] ?
                    Math.max(max, (right-left)*height[left++]) :
                    Math.max(max, (right-left)*height[right--]);
        }

        return max;

        /*
        //暴力
        int max = 0;
        int leftFlag = height[0];
        int rightFlag = 0;

        for (int i = 0; i < height.length-1; i++) {
            if (height[i] >= leftFlag){
                leftFlag = height[i];
                rightFlag = height[height.length-1];
                for (int j = height.length-1; j > i; j--) {
                    if (height[j] >= rightFlag) {
                        max = max > (j-i)*Math.min(height[i], height[j]) ? max : (j-i)*Math.min(height[i], height[j]);
                    }
                }
            }
        }
        return max;
         */
    }

}
