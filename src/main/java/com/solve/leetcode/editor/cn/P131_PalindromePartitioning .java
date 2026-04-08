//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1740 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 分割回文串
 * @author wuou
 * @date 2024-03-07 11:03:30
 */
class P131_PalindromePartitioning{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P131_PalindromePartitioning().new Solution();
        solution.partition("aab");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> list = new ArrayList<>();
    Character [] path;
    public List<List<String>> partition(String s) {
        path = new Character[s.length()];
        dfs(s, 0);
        return ans;
    }
    public void dfs(String s, int u) {
        for (int i = u; i < s.length(); i++) {
            path[i] = s.charAt(i);
            StringBuilder str = new StringBuilder();
            for (Character c : path) {
                if (Objects.nonNull(c)) {
                    str.append(c);
                }
            }
            if (judgeStr(str.toString())) {
                list.add(str.toString());
            }
            dfs(s, i+1);
        }

    }
    public boolean judgeStr(String str) {
        if (str.isEmpty()) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }
        boolean res = true;
        for (int i = 0, j = str.length() - 1; i <= j && j >= 0; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                res = false;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}