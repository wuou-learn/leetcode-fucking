//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1225 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 不同路径 II
 * @author wuou
 * @date 2024-03-24 20:25:29
 */
class P63_UniquePathsIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P63_UniquePathsIi().new Solution();
//        solution.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
//        solution.uniquePathsWithObstacles(new int[][]{{1,0}});
        solution.uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int [][] dp = new int [x+1][y+1];
        dp[1][1] = 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                if (obstacleGrid[i-1][j-1] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 1 && j == 1) continue;

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[x][y];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}