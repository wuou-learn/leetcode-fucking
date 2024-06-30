//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1655 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 最小路径和
 * @author wuou
 * @date 2024-03-24 20:40:43
 */
class P64_MinimumPathSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P64_MinimumPathSum().new Solution();
        solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] a) {
        int x = a.length;
        int y = a[0].length;
        int [][] dp = new int[x+1][y+1];
        dp[1][1] = a[0][0];
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (i == 1) {
                    dp[i][j] = dp[i][j-1] + a[i-1][j-1];
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = dp[i-1][j] + a[i-1][j-1];
                    continue;
                }
                dp[i][j] = Math.min(dp[i][j-1] + a[i-1][j-1], dp[i-1][j] + a[i-1][j-1]);
            }
        }
        return dp[x][y];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}