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
//
// Related Topics 字典树 字符串 👍 3123 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 最长公共前缀
 * @author wuou
 * @date 2024-05-15 19:58:05
 */
class P14_LongestCommonPrefix{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P14_LongestCommonPrefix().new Solution();
        solution.longestCommonPrefix(new String[]{"ab", "a"});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        if ("".equals(strs[0])) {
            return res.toString();
        }
        String first = strs[0];
        for (int i = 0; i < first.length() ; i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i > strs[j].length()-1 || strs[j].charAt(i) != c) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}