//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3533 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * @author wuou
 * @date 2024-03-16 11:12:38
 */
class P22_GenerateParentheses{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P22_GenerateParentheses().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        dfs(n,0,0,"");
        return ans;
    }
    public void dfs(int n, int lc, int rc, String seq){
        if (lc == n && rc == n) {
            ans.add(seq);
            return;
        }
        // 任意前缀中'('的数量>=')'的数量
        if (lc < n) {
            dfs(n, lc + 1, rc, seq+"(");
        }
        if (rc < n && lc > rc) {
            dfs(n, lc, rc+1, seq+")");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}