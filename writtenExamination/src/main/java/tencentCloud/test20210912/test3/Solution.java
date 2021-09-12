package tencentCloud.test20210912.test3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 119. 杨辉三角 II https://leetcode-cn.com/problems/pascals-triangle-ii/
 *
 * @author Shenhan
 * @create 2021-09-12-19:44
 */
public class Solution {

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

    @Test
    public void test() {
        System.out.println(getRow(3));
    }
}
