package com.solve.leetcode.editor.cn;

class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        solution.repeatedSubstringPattern("aba");
        System.out.println(7%3);
        System.out.println(3%1);
    }

    /**
     * 重复的子字符串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            String p = " " + s;
            char[] pp = p.toCharArray();
            int [] next = new int[pp.length];
            for (int i = 2, j = 0; i < pp.length; i++) {
                while (j!=0 && pp[i] != pp[j+1]) {
                    j = next[j];
                }
                if (pp[i] == pp[j+1]) {
                    j++;
                }
                next[i] = j;
            }
            int len = s.length()-next[s.length()];
            return len < s.length() && (s.length() % len) == 0;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
