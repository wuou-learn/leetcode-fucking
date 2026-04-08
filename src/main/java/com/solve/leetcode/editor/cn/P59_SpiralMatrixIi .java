//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1293 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 螺旋矩阵 II
 * @author wuou
 * @date 2024-06-24 20:26:46
 */
class P59_SpiralMatrixIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P59_SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int [][] res = new int[n][n];
        // -> (0, 1)
        // | (1, 0)
        // <- (0, -1)
        // 上 (-1, 0)
        int [] dx = new int[]{0, 1, 0, -1};
        int [] dy = new int[]{1, 0, -1, 0};
        boolean[][] b = new boolean[n][n];
        for (int i = 1,x = 0, y = 0, s = 0, t = 0; i <= n*n; i++) {
            res[x][y] = i;
            int q = x + dx[s % 4];
            int w = y + dy[t % 4];
            b[x][y] = true;
            if (q >= n || w >= n || q < 0 || w < 0 || b[q][w]) {
                s ++;
                t ++;
                x += dx[s % 4];
                y += dy[t % 4];
            } else {
                x = q;
                y = w;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}