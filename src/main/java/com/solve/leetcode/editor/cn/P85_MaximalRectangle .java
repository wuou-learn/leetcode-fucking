//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1649 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Stack;

/**
 * 最大矩形
 * @author wuou
 * @date 2024-07-13 15:10:46
 */
class P85_MaximalRectangle{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P85_MaximalRectangle().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] h = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0) {
                        h[i][j] = 1 + h[i-1][j];
                    } else {
                        h[i][j] = 1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, largestRectangleArea(h[i]));
        }
        return res;
    }

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