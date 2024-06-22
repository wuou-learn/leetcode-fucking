//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2351 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 合并区间
 * @author wuou
 * @date 2024-06-20 19:11:45
 */
class P56_MergeIntervals{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P56_MergeIntervals().new Solution();
        solution.merge(new int [][]{{1,3},{2,6},{15,18},{8,10}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        // 按左端点排序
        // 判断是否有交集，有交集则更新右端点
        // 没有交集则保存当前区间
        Arrays.sort(intervals, Comparator.comparingInt(t -> t[0]));
        // 第一个区间
        int l = intervals[0][0], r = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            // 下一区间的左端点大于第一个区间的右端点 则没交集 保存当前区间
            if (intervals[i][0] > r) {
                res.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            } else {
                r = Math.max(r, intervals[i][1]);
            }
        }
        res.add(new int[]{l,r});
        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}