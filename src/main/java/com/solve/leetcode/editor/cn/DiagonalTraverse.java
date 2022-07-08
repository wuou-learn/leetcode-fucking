//给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,4,7,5,3,6,8,9]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[1,2],[3,4]]
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// -10⁵ <= mat[i][j] <= 10⁵ 
// 
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 376, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class DiagonalTraverse {
    public static void main(String[] args) {
        Solution solution = new DiagonalTraverse().new Solution();
        solution.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

    /**
     * 对角线遍历
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0){
                return new int[0];
            }

            int m = matrix.length;
            int n = matrix[0].length;
            int[] nums = new int[m * n];

            int k = 0;
            boolean flag = true;
            for (int i = 0; i < m + n; i++){
                int pm = flag ? m : n;
                int pn = flag ? n : m;

                int x = (i < pm) ? i : pm - 1;
                int y = i - x;

                while (x >= 0 && y < pn){
                    nums[k++] = flag ? matrix[x][y] : matrix[y][x];
                    x--;
                    y++;
                }
                flag = !flag;
            }

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}