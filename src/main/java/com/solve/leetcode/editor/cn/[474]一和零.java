package com.solve.leetcode.editor.cn;

class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();
        solution.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3);
    }

    /**
     * 多背包问题
     *
     * 一和零
     *
     * 状态表示：从字符串长度i中找出 最多m0 n1
     *
     * dp[m][n]
     * 状态集合：f(i,m,n)
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
            int[][][] dp = new int[len + 1][m + 1][n + 1];

            for (int i = 1; i <= len; i++) {
                int[] count = count(strs[i-1]);
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        dp[i][j][k] = dp[i - 1][j][k];
                        int zero = count[0];
                        int one = count[1];
                        if (j >= zero && k >= one) {
                            dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zero][k-one]+1);
                        }
                    }
                }
            }
            return dp[len][m][n];
        }

        public int[] count(String str) {
            int[] cnt = new int[2];
            for (char c : str.toCharArray()) {
                cnt[c - '0']++;
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
