//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 7201 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 最长回文子串
 * @author wuou
 * @date 2024-05-10 20:01:48
 */
class P5_LongestPalindromicSubstring{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P5_LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("eabcb");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int l = i-1;
            int r = i+1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // 有可能遍历的长度超出字符串的长度
            // 为什么是r-l-1? 在上述while循环结束后，会指针会停止在相同字母的两侧
            // 所以：回文字符串长度=（r-1）-（l+1）+1=r-l-1
            // 取最长回文字符串
            if (res.length() < r-l-1) {
                // 结束循环时r在相同串的+1出，substring正好不包含endIndex
                res = s.substring(l+1,r);
            }


            l = i;
            r = i+1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            if (res.length() < r-l-1) {
                res = s.substring(l+1,r);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}