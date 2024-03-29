//给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。 
//
// 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
//输出：13
//解释：
//所有非零偏移下降路径包括：
//[1,5,9], [1,5,7], [1,6,7], [1,6,8],
//[2,4,8], [2,4,9], [2,6,7], [2,6,8],
//[3,4,8], [3,4,9], [3,5,7], [3,5,9]
//下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[7]]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 1 <= n <= 200 
// -99 <= grid[i][j] <= 99 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 190 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 下降路径最小和  II
 * @author wuou
 * @date 2024-03-25 21:14:41
 */
class P1289_MinimumFallingPathSumIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1289_MinimumFallingPathSumIi().new Solution();
        solution.minFallingPathSum(new int[][]{{-73,61,43,-48,-36},{3,30,27,57,10},{96,-76,84,59,-15},{5,-49,76,31,-7},{97,91,61,-46,67}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int x = matrix.length;
        int y = matrix[0].length;
        int [][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < x; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int m = matrix[i][j];
                for (int b=j+1; b < y; b++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][b]+m);
                }
                for (int a = j-1; a >= 0; a--) {
                    dp[i][j] = Math.min(dp[i-1][a]+m, dp[i][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < y; j++) {
            ans = Math.min(dp[x-1][j], ans);
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}