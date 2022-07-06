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
// Related Topics数组 | 矩阵 | 模拟 
//
// 👍 753, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.LinkedList;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
    }

    /**
     * 螺旋矩阵 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int [][] res = new int[n][n];
            int left = 0;
            int right = n-1;
            int top = 0;
            int bottom = n-1;
            int sum = n*n;
            int num = 1;
            while (sum >= 1) {
                for (int i =left; i <= right && sum >= 1; i++) {
                    res[top][i] = num;
                    num++;
                    sum--;
                }
                top++;
                for (int i =top; i <= bottom && sum >= 1; i++) {
                    res[i][right] = num;
                    num++;
                    sum--;
                }
                right--;
                for (int i =right; i >= left && sum >= 1; i--) {
                    res[bottom][i] = num;
                    num++;
                    sum--;
                }
                bottom--;
                for (int i =bottom; i >= top && sum >= 1; i--) {
                    res[i][left] = num;
                    num++;
                    sum--;
                }
                left++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}