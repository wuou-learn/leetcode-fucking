package com.solve.leetcode.editor.cn;


class MinimumPathSum {
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        solution.minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    /**
     * 最小路径和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minPathSum(int[][] grid) {
            int y = grid.length;
            int x = grid[0].length;
            int[][] res = new int[y + 1][x + 1];
            res[0][0] = 0;

            for (int i = 1; i <= y; i++) {
                for (int j = 1; j <= x; j++) {
                    if (i == 1) {
                        res[i][j] = res[i][j - 1] + grid[i - 1][j - 1];
                        continue;
                    }

                    if (j == 1) {
                        res[i][j] = res[i - 1][j] + grid[i - 1][j - 1];
                    } else {
                        res[i][j] = Math.min(res[i][j - 1] + grid[i - 1][j - 1], res[i - 1][j] + grid[i - 1][j - 1]);
                    }
                }
            }
            return res[y][x];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
