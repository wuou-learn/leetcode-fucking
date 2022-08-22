package com.solve.leetcode.editor.cn;

class UniquePathsIi {
    public static void main(String[] args) {
        Solution solution = new UniquePathsIi().new Solution();
        solution.uniquePathsWithObstacles(new int[][]{{0,1,0}});
    }

    /**
     * 不同路径 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int y = obstacleGrid.length;
            int x = obstacleGrid[0].length;

            int [][]dp = new int[y+1][x+1];
            for (int i = 0; i < y; i++) {
                System.arraycopy(obstacleGrid[i], 0, dp[i + 1], 1, x);
            }
            dp[1][0] = 1;
            for (int i = 1; i <= y; i++) {
                for (int j = 1; j <= x; j++) {
                    if (dp[i][j] == 1) {
                        dp[i][j] = 0;
                        continue;
                    }
                    if (i == 1) {
                        dp[i][j] = dp[i][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }
            
            return dp[y][x];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
