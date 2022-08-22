package com.solve.leetcode.editor.cn;

import java.util.Arrays;

class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
        solution.uniquePaths(3, 3);
    }

    /**
     * 不同路径
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int [][] dp = new int[m+1][n+1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <=n; j++) {
                    if (i == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j-1] + dp[i-1][j];
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
