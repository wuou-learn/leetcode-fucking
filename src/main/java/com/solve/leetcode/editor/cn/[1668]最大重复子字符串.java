package com.solve.leetcode.editor.cn;

class MaximumRepeatingSubstring {
    public static void main(String[] args) {
        Solution solution = new MaximumRepeatingSubstring().new Solution();
        solution.maxRepeating("ababc", "ab");
    }

    /**
     * 最大重复子字符串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepeating(String sequence, String word) {
            String s = " " + sequence;
            char[] ss = s.toCharArray();
            char[] pp = new char[ss.length];
            pp[0] = ' ';
            for (int i = 1; i < pp.length; i++) {
                pp[i] = word.charAt((i - 1) % word.length());
            }

            int [] next = new int [pp.length];
            for (int i = 2, j = 0; i < pp.length; i++) {
                while (j != 0 && pp[i] != pp[j+1]) {
                    j = next[j];
                }
                if (pp[i] == pp[j+1]) {
                    j++;
                }
                next[i] = j;
            }

            int res = 0;
            for (int i = 1, j = 0; i < ss.length; i++) {
                while (j != 0 && ss[i] != pp[j+1]) {
                    j = next[j];
                }
                if (ss[i] == pp[j+1]) {
                    j++;
                }
                res = Math.max(res, j / word.length());
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
