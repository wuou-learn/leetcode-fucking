//给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 示例 2: 
//
// 
//输入： s = "God Ding"
//输出："doG gniD"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s 包含可打印的 ASCII 字符。 
// s 不包含任何开头或结尾空格。 
// s 里 至少 有一个词。 
// s 中的所有单词都用一个空格隔开。 
// 
// Related Topics双指针 | 字符串 
//
// 👍 461, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        Solution solution = new ReverseWordsInAStringIii().new Solution();
    }

    /**
     * 反转字符串中的单词 III
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            String[] s1 = s.split(" ");
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s1.length; i++) {
                result.append(reverse(s1[i]));
                if (i!=s1.length - 1) {
                    result.append(" ");
                }
            }
            return result.toString();
        }

        public String reverse(String request){
            char[] chars = request.toCharArray();
            for (int i = 0, j = request.length()-1; i < request.length() && j >= i; i++,j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}