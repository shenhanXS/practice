package dailyPractice.test_119_getRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author Shenhan
 * @create 2021-09-13-15:56
 */
public class Solution_119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 0));
        List<Integer> tempList;
        for (int i = 0; i < rowIndex; i++) {
            tempList = new ArrayList<>();
            for (int j = 0; j < i + 3; j++) {
                if (j == 0) {
                    tempList.add(0);
                } else {
                    tempList.add(list.get(j - 1) + list.get(j));
                }
            }
            tempList.add(0);
            list.clear();
            list.addAll(tempList);

        }
        list.remove(0);
        list.remove(list.size() - 1);
        return list;
    }

}
