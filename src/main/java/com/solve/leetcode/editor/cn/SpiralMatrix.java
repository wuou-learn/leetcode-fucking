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
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 1131, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrix().new Solution();
        solution.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }

    /**
     * 54 螺旋矩阵
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new LinkedList<>();
            int left = 0;
            int right = matrix[0].length-1;
            int top = 0;
            int bottom = matrix.length-1;
            int sum = matrix.length * matrix[0].length;
            while (sum >= 1) {
                for (int i = left; i <= right && sum >= 1; i++) {
                    res.add(matrix[top][i]);
                    sum--;
                }
                top++;
                for (int i = top; i <= bottom && sum >=1 ; i++){
                    res.add(matrix[i][right]);
                    sum--;
                }
                right--;
                for (int i = right; i >= left && sum >=1; i--) {
                    res.add(matrix[bottom][i]);
                    sum--;
                }
                bottom--;
                for(int i = bottom; i >= top && sum >=1; i--) {
                    res.add(matrix[i][left]);
                    sum--;
                }
                left++;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}