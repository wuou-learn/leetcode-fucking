package com.solve.leetcode.editor.cn;

class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        Solution solution = new FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
    }

    /**
     * 找出字符串中第一个匹配项的下标
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            // 数据范围
            int [] next = new int[10010];
            String s = " " + haystack;
            int n = haystack.length();
            char[] ss = s.toCharArray();
            String p = " " + needle;
            int m = needle.length();
            char[] pp = p.toCharArray();

            // 找到最小匹配前缀
            for(int i = 2, j = 0; i <= m; i++) {
                while (j != 0 && pp[i] != pp[j+1]) {
                    j = next[j];
                }
                if (pp[i] == pp[j+1]) {
                    j++;
                }
                next[i] = j;
            }

            // kmp匹配
            for (int i = 1, j = 0; i <= n; i++) {
                while (j != 0 && ss[i] != pp[j+1]) {
                    j = next[j];
                }
                if (ss[i] == pp[j+1]) {
                    j++;
                }
                if (j == m) {
                    return i-m;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
