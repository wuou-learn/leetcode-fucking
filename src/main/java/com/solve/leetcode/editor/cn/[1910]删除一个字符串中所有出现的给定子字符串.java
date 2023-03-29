package com.solve.leetcode.editor.cn;

class RemoveAllOccurrencesOfASubstring {
    public static void main(String[] args) {
        Solution solution = new RemoveAllOccurrencesOfASubstring().new Solution();
        solution.removeOccurrences("eemckxmckx", "emckx");
    }

    /**
     * 删除一个字符串中所有出现的给定子字符串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeOccurrences(String s, String part) {
            String p = " " + part;
            char[] pp = p.toCharArray();
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

            boolean flag = true;
            String str = " " + s;
            while (flag) {
                if (str.equals(" ")) {
                    break;
                }
                char[] ss = str.toCharArray();
                for (int i = 1, j = 0; i < ss.length; i++) {
                    while (j != 0 && ss[i] != pp[j+1]) {
                        j = next[j];
                    }
                    if (ss[i] == pp[j+1]) {
                        j++;
                    }
                    if (j == part.length()) {
                        str = str.substring(0, i - part.length() + 1) + str.substring(i+1);
                        break;
                    }
                    if (i == ss.length - 1) {
                        flag = false;
                    }
                }
            }
            return str.substring(1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
