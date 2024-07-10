//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3416 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 编辑距离
 * @author wuou
 * @date 2024-07-09 22:33:42
 */
class P72_EditDistance{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P72_EditDistance().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        /**
         * dp
         * - 状态表示f(i,j)
         *   - 集合：将word1->word2所有操作按顺序操作的集合
         *   - 属性：取最小操作数
         * - 状态计算：划分子集求每个子集的最小值
         *   分为六种情况：枚举最后一个字母的操作，使得word1[1-i]->word2[1-j]
         *   char last = word1.charAt(word1.len-1);
         *   - 删除last = f(i-1,j) + 1
         *   - 增加last = f(i,j-1) + 1
         *   - 修改last = f(i-1,j-1) + 1(or)0
         */
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int n = a.length;
        int m = b.length;
        int [][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                if (a[i-1] != b[j-1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]+1);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}