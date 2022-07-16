//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics字符串 
//
// 👍 174, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class NumberOfSegmentsInAString {
    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
        solution.countSegments("");
    }

    /**
     * 字符串中的单词数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSegments(String s) {
            int res = 0;
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                if (!"".equals(s1[i])) {
                    res++;
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}