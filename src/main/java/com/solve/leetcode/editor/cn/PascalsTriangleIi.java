//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics数组 | 动态规划 
//
// 👍 407, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        solution.getRow(2);
    }

    /**
     * 杨辉三角 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < rowIndex+1; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < i+1; j++) {
                    if (j==0 || j==i) {
                        list.add(1);
                    } else if (rowIndex+1 >= 3){
                        list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
                res.add(list);
            }
            return res.get(rowIndex);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}