//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics字符串 
//
// 👍 2340, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.Objects;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        solution.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }

    /**
     * 最长公共前缀
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 1) {
                return strs[0];
            }
            String min = strs[0];
            StringBuilder sb = null;
            for (int i = 1; i<strs.length; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < strs[i].length(); j++) {
                    if (j >= min.length()) {
                        break;
                    }
                    if (strs[i].charAt(j) == min.charAt(j)) {
                        sb.append(min.charAt(j));
                    }
                    if (strs[i].charAt(j) != min.charAt(j)) {
                        break;
                    }
                }
                if (sb.length() < min.length()) {
                    min = sb.toString();
                }

            }
            return min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}