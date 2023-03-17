package com.solve.leetcode.editor.cn;

class RepeatedStringMatch {
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
        solution.repeatedStringMatch("abcd", "cdabcdab");
    }

    /**
     * 重复叠加字符串匹配
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int repeatedStringMatch(String a, String b) {
            int N = 10010;
            // b -> a
            String p = " " + b;
            char[] pp = p.toCharArray();
            char[] ss = new char[N];
            ss[0] = ' ';
            for (int i = 1; i < N; i++) {
                ss[i] = a.charAt((i-1)%a.length());
            }

            int [] next = new int[N];
            for (int i = 2, j = 0; i < pp.length; i++) {
                while (j != 0 && pp[i] != pp[j+1]) {
                    j = next[j];
                }
                if (pp[i] == pp[j+1]) {
                    j++;
                }
                next[i] = j;
            }

            for (int i = 1, j = 0; i < ss.length; i++) {
                while (j != 0 && ss[i] != pp[j+1]) {
                    j = next[j];
                }
                if (ss[i] == pp[j+1]) {
                    j++;
                }
                if (j == b.length()) {
                    return ((i+a.length()-1)/a.length());
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
