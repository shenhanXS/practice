package hot_100.test_207;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Shenhan
 * @create 2021-08-13-17:09
 */
public class Solution_beta {

    public static void main(String[] args) {
        Solution_beta solutionBeta = new Solution_beta();
        int[][] prerequisites = {{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}};
        int numCourses = 7;
        System.out.println(solutionBeta.canFinish(numCourses, prerequisites));
    }

    // 自己写的 dfs , 略微复杂
    List<List<Integer>> list = new ArrayList<>();
    HashSet<Integer> canFinish = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            boolean flag = true;
            set.add(i);
            for (int j = 0; j < list.get(i).size(); j++) {
                if (!canFinish.contains(list.get(i).get(j))) {
                    flag = false;
                }
            }
            if (flag) {
                canFinish.add(i);
                continue;
            }
            if (!findPreRequisites(i, set)) {
                return false;
            }
            set.clear();
        }
        return true;
    }
    public boolean findPreRequisites(int i, HashSet<Integer> set) {
        int preNum = list.get(i).size();
        boolean flag = true;
        if (preNum == 0) {
            set.remove(i);
            canFinish.add(i);
            return true;
        }else {
            for (int j = 0; j < preNum && flag; j++) {
                int courseNum = list.get(i).get(j);
                if (canFinish.contains(courseNum)) continue;
                if (set.contains(courseNum)) {
                    return false;
                }
                set.add(courseNum);
                flag = findPreRequisites(courseNum, set);
            }
        }
        canFinish.add(i);
        set.remove(i);
        return flag;
    }
}
