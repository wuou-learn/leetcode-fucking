//给你一个 m x n 的矩阵 mat 和一个整数 k ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 
//mat[r][c] 的和： 
//
// 
// i - k <= r <= i + k, 
// j - k <= c <= j + k 且 
// (r, c) 在矩阵内。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
//输出：[[12,21,16],[27,45,33],[24,39,28]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
//输出：[[45,45,45],[45,45,45],[45,45,45]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n, k <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 218 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 矩阵区域和
 * @author wuou
 * @date 2025-08-26 17:14:19
 */
class P1314_MatrixBlockSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1314_MatrixBlockSum().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        int [][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = Math.max(0, i - k);
                int b = Math.min(m - 1, i + k);
                int l = Math.max(0, j - k);
                int r = Math.min(n - 1, j + k);

                ans[i][j] = dp[b + 1][r + 1] - dp[b + 1][l] - dp[t][r + 1] + dp[t][l];
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}