package dailyPractice;

/**
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 * @author Shenhan
 * @create 2021-04-22-20:14
 */
public class test_304_NumMatrix_sumRegionv {

    // 方法二:
    // 另起一个二维数组，存储左上角第一个开始到每个点矩形区域求和的值
    int[][] sum;

    public test_304_NumMatrix_sumRegionv(int[][] matrix){
        int m = matrix.length;
        int n = matrix.length == 0 ? 0 : matrix[0].length;
        sum = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i-1][j] + sum[i][j-1] + matrix[i-1][j-1] - sum[i-1][j-1];
            }
        }

    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }

    //基本思路；方法一：从左上角到右下角所有元素求和；时间成本过高
//    int[][] matrix;
//
//    public test_304_NumMatrix_sumRegionv(int[][] matrix){
//        this.matrix = matrix;
//    }
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//
//        int sum = 0;
//
//        for (int i = row1; i <= row2; i++) {
//            for (int j = col1; j <= col2; j++) {
//                sum += matrix[i][j];
//            }
//        }
//
//        return sum;
//    }


    public static void main(String[] args) {
        int [][] matrix = {
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}};

        test_304_NumMatrix_sumRegionv obj = new test_304_NumMatrix_sumRegionv(matrix);
        int i = obj.sumRegion(1, 2, 2, 4);
        System.out.println(i);



    }



}
