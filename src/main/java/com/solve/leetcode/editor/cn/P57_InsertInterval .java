//给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区
//间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的
//开始和结束。 
//
// 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，
//可以合并区间）。 
//
// 返回插入之后的 intervals。 
//
// 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁵ 
// intervals 根据 starti 按 升序 排列 
// newInterval.length == 2 
// 0 <= start <= end <= 10⁵ 
// 
//
// Related Topics 数组 👍 894 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 插入区间
 * @author wuou
 * @date 2024-06-22 21:06:34
 */
class P57_InsertInterval{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P57_InsertInterval().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // 区间合并两个特点
        // 1. 按照左端点进行排序
        // 2. 有交集的更新右端点
        //    没有交集的保存当前区间
        int[][] a = Arrays.copyOf(intervals, intervals.length + 1);
        a[intervals.length] = newInterval;
        Arrays.sort(a, Comparator.comparingInt(t -> t[0]));
        List<int[]> res = new ArrayList<>();
        int l = a[0][0];
        int r = a[0][1];
        for (int i = 1; i < a.length; i++) {
            if (a[i][0] > r) {
                res.add(new int[]{l, r});
                l = a[i][0];
                r = a[i][1];
            } else {
                r = Math.max(r, a[i][1]);
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[res.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}