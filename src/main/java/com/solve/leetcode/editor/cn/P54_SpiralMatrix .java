//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1701 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author wuou
 * @date 2024-06-19 18:28:31
 */
class P54_SpiralMatrix{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P54_SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // 根据偏移量进行移动
        //  ------->y
        //  |
        //  |
        //  x
        // 右移动（0,1）
        // 下移动（1,0）
        // 左移动（0,-1）
        // 上移动（-1,0）
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean [][] b = new boolean[m][n];

        for (int i = 0, x = 0, y = 0, s = 0, t = 0; i < m*n; i++) {
            res.add(matrix[x][y]);
            b[x][y] = true;

            int q = x + dx[s%4];
            int w = y + dy[t%4];
            if (q >= m || w >=n || w < 0 || q < 0 || b[q][w]) {
                s ++;
                t ++;
                x += dx[s%4];
                y += dy[t%4];
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