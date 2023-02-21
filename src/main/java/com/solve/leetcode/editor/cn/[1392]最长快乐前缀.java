package com.solve.leetcode.editor.cn;

class LongestHappyPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestHappyPrefix().new Solution();
        solution.longestPrefix("level");
    }

    /**
     * 最长快乐前缀
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPrefix(String s) {
            // 数据范围
            int [] next = new int[100010];
            String p = " " + s;
            char[] pp = p.toCharArray();
            // 找到最短匹配前缀
            for (int i = 2, j = 0; i <= s.length(); i++) {
                while (j != 0 && pp[i] != pp[j+1]) {
                    j = next[j];
                }
                if (pp[i] == pp[j+1]) {
                    j++;
                }
                next[i] = j;
            }
            return s.substring(0, next[s.length()]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
