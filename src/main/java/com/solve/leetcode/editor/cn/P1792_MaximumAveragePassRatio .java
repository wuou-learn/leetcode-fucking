//一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [
//passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。 
//
// 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 
//extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。 
//
// 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。 
//
// 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10⁻⁵ 以内的结果都会视为正确结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//输出：0.78333
//解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
// 
//
// 示例 2： 
//
// 
//输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//输出：0.53485
// 
//
// 
//
// 提示： 
//
// 
// 1 <= classes.length <= 10⁵ 
// classes[i].length == 2 
// 1 <= passi <= totali <= 10⁵ 
// 1 <= extraStudents <= 10⁵ 
// 
//
// Related Topics 贪心 数组 堆（优先队列） 👍 183 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大平均通过率
 * @author wuou
 * @date 2025-09-01 16:07:47
 */
class P1792_MaximumAveragePassRatio{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1792_MaximumAveragePassRatio().new Solution();
        solution.maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 4);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    class Info{
        int p;
        int t;
        double rate;

        public Info(int p, int t) {
            this.p = p;
            this.t = t;
            this.rate = calRate();
        }

        public double calRate() {
            return (double) (p + 1) / (t + 1) - (double) p / t;
        }

        public void add() {
            p++;
            t++;
            rate = calRate();
        }
    }
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Info> queue = new PriorityQueue<>(
                (a,b) -> Double.compare(b.rate, a.rate)
        );

        for (int [] clazz : classes) {
            queue.offer(new Info(clazz[0], clazz[1]));
        }

        for (int k = 0; k < extraStudents; k++) {
            Info poll = queue.poll();
            poll.add();
            queue.offer(poll);
        }

        double sum = 0;
        while (!queue.isEmpty()) {
            Info poll = queue.poll();
            sum += (double) poll.p / poll.t;
        }
        return sum / classes.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}