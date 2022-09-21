//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics数组 | 双指针 | 字符串 | 排序 
//
// 👍 310, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.*;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        String [] str = new String []{"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
        solution.findLongestWord("aewfafwafjlwajflwajflwafj", Arrays.asList(str));
    }

    /**
     * 通过删除字母匹配到字典里最长单词
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            for (String str : dictionary) {
                // 记录匹配的字符长度
                int index = 0;
                // 字符串指针
                int i = 0;
                // 字典指针
                int j = 0;
                while (i < str.length() && j < s.length()) {
                    if (str.charAt(i) == s.charAt(j)) {
                        index++;
                        i++;
                    }
                    j++;
                }
                if (index == str.length()) {
                    if (index > res.length() && str.compareTo(res) < 0) {
                        res = str;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}