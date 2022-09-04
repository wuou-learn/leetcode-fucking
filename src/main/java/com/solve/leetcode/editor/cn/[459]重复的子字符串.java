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
            String str = s + s;
            return str.substring(1, str.length()-1).contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
