//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数学 动态规划 👍 2019 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 完全平方数
 * @author wuou
 * @date 2024-09-07 20:13:07
 */
class P279_PerfectSquares{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P279_PerfectSquares().new Solution();
        solution.numSquares(12);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int max = n / 2;
        int [] f = new int [n + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        f[1] = 1;
        for (int i = 1; i <= max; i++) {
            int c = i * i;
            for (int j = c; j <= n; j++) {
                if (f[j - c] != Integer.MAX_VALUE) {
                    f[j] = Math.min(f[j], f[j - c] + 1);
                }
            }
        }
        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}