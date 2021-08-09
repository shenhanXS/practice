package hot_100;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 *
 * @author Shenhan
 * @create 2021-06-19-16:00
 */
public class test_48_rotate {

    // 官方解法三
    // 两次镜像翻转实现旋转
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp = 0;
        // 水平镜像
        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < len; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[len - i - 1][j];
                matrix[len - i - 1][j] = temp;
            }
        }
        // 副对角线镜像
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    /*
    // 官方解法二
    // 分块旋转，分为上左、上右、下左、下右四个块进行处理
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int temp = 0;
        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < (len+1)/2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }

     */

}
