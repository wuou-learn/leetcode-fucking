package com.solve.leetcode.editor.cn;

import java.util.*;

class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        solution.repeatedSubstringPattern("aabaaba");
    }

    /**
     * 重复的子字符串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            String ss = " " + s;
            int [] arr = new int[ss.length()];
            char[] chars = ss.toCharArray();
            for (int i = 2,j = 0; i < chars.length; i++) {
                while (j != 0 && chars[i] != chars[j+1]) {
                    j = arr[j];
                }
                if (chars[i] == chars[j+1]) {
                    j++;
                }
                arr[i] = j;
            }
            int t = s.length()-arr[s.length()];

            return t < s.length() && s.length()%t == 0;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
