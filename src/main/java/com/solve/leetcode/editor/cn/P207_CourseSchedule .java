//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 2323 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 课程表
 * @author wuou
 * @date 2026-03-12 15:28:18
 */
class P207_CourseSchedule{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P207_CourseSchedule().new Solution();
        solution.canFinish(2,new int[][]{{0,1}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 2 [0,1]
        // 1 -> 0
        // 0 : []
        // 1 : [0]

        // 2 [1,0]
        // 0 -> 1
        // 0 : [1]
        // 1 : []
        List<List<Integer>> list = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        int [] in = new int[numCourses];
        for (int [] p : prerequisites) {
            list.get(p[1]).add(p[0]);
            in[p[0]] ++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0 ; i < in.length; i++) {
            if (in[i] == 0) deque.offer(i);
        }
        if (deque.isEmpty()) return false;

        int count = 0;
        while (!deque.isEmpty()) {
            Integer poll = deque.poll();
            count++;

            List<Integer> nber = list.get(poll);
            for (Integer n : nber) {
                if (--in[n] == 0) {
                    deque.offer(n);
                }
            }

        }
        return count == numCourses;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}