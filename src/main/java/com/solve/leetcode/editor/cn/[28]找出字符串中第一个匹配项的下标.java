package com.solve.leetcode.editor.cn;

class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        solution.strStr("sadbustad", "sad");
    }

    /**
     * 找出字符串中第一个匹配项的下标
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            String p = " " + needle;
            char[] pp = p.toCharArray();
            String s = " " + haystack;
            char[] ss = s.toCharArray();
            int[] next = new int[pp.length];
            for (int i = 2, j = 0; i < pp.length; i++) {
                while (j!=0 && pp[i] != pp[j+1]) {
                    j = next[j];
                }
                if (pp[i] == pp[j+1]) {
                    j++;
                }
                next[i] = j;
            }

            for (int i = 1, j = 0; i < ss.length; i++) {
                while (j!=0 && ss[i] != pp[j+1]) {
                    j = next[j];
                }
                if (ss[i] == pp[j+1]) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length();
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
