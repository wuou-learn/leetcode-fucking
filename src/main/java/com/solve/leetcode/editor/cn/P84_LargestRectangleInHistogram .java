//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2749 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * @author wuou
 * @date 2024-07-13 14:38:27
 */
class P84_LargestRectangleInHistogram{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P84_LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int []{2,1,5,6,2,3});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        int [] left = new int[h.length];
        int [] right = new int[h.length];

        for (int i = 0; i < h.length; i ++) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = h.length - 1; i >= 0; i --) {
            while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = h.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int res = 0;
        for (int i = 0; i < h.length; i++) {
            res = Math.max(res, h[i] * (right[i] - left[i] - 1));
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}