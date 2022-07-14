//我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如 "USA" 。 
// 单词中所有字母都不是大写，比如 "leetcode" 。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。 
// 
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word = "USA"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：word = "FlaG"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 由小写和大写英文字母组成 
// 
// Related Topics字符串 
//
// 👍 206, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class DetectCapital {
    public static void main(String[] args) {
        Solution solution = new DetectCapital().new Solution();
        solution.detectCapitalUse("USA");
    }

    /**
     * 检测大写字母
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean detectCapitalUse(String word) {
            if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
                return false;
            }
            int u = 0;
            int l = 0;
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    u++;
                } else {
                    l++;
                }
            }
            if (Character.isUpperCase(word.charAt(0))) {
                // 第一个字母为大写 其他字母都为大写。或者小写
                return u == word.length() - 1 || l == word.length() - 1;
            } else {
                // 第一个字母为小写 其他字母必须为小写
                return l == word.length() - 1;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}