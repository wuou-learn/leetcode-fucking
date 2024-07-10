//给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
//输出：[[1,0,1],[0,0,0],[1,0,1]]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[0].length 
// 1 <= m, n <= 200 
// -2³¹ <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 一个直观的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个仅使用常量空间的解决方案吗？ 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 1077 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 矩阵置零
 * @author wuou
 * @date 2024-07-10 18:25:49
 */
class P73_SetMatrixZeroes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P73_SetMatrixZeroes().new Solution();
        solution.setZeroes(new int[][]{{1},{0}});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        /**
         * 第0行表示：对应的每列中是否包含0
         * 第0列表示：对应的每行中是否包含0
         *
         * 第0行以及第0列 用两个新变量表示是否包含0
         * r0      c0
         * 0 => 表示包含0
         * 1 => 表示不包含0
         */
        int r0 = 1;
        int c0 = 1;
        int x = matrix.length;
        int y = matrix[0].length;
        // 第一行是否包含0
        for (int i = 0; i < y; i++) {
            int num = matrix[0][i];
            if (num == 0) {
                r0 = 0;
                break;
            }
        }

        // 第一列是否包含0
        for (int i = 0; i < x; i++) {
            int num = matrix[i][0];
            if (num == 0) {
                c0 = 0;
                break;
            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                if (matrix[i][j] == 0) {
                    // 第i行
                    matrix[i][0] = 0;
                    // 第j列
                    matrix[0][j] = 0;
                }
            }
        }


        // 循环列 列中有0 则该行=0
        for (int i = 1; i < x; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < y; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 循环行 行中有0 则该列=0
        for (int i = 1; i < y; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < x; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        // 第一行包含0
        if (r0 == 0) {
            for (int i = 0; i < y; i++) {
                matrix[0][i] = 0;
            }
        }
        // 第一列包含0
        if (c0 == 0) {
            for (int i = 0; i < x; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}