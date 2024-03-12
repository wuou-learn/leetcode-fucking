//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 571 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 字母大小写全排列
 * @author wuou
 * @date 2024-03-11 10:09:00
 */
class P784_LetterCasePermutation{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P784_LetterCasePermutation().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        dfs(s.toCharArray(), 0);
        return ans;
    }
    public void dfs(char[] s, int u) {
        if (u == s.length) {
            ans.add(new String(s));
        } else {
            dfs(s, u+1);
            if (Character.isAlphabetic(s[u])) {
                s[u] ^= 32;
                dfs(s, u+1);
                s[u] ^= 32;
            }
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}