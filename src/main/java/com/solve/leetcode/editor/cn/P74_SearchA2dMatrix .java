//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 936 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 搜索二维矩阵
 * @author wuou
 * @date 2024-07-10 21:17:36
 */
class P74_SearchA2dMatrix{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P74_SearchA2dMatrix().new Solution();
        solution.searchMatrix(new int[][]{{1,1}}, 2);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length;
        int y = matrix[0].length;
        int l = 0, r = x * y - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (matrix[mid / y][mid % y] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return matrix[r / y][r % y] == target;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}