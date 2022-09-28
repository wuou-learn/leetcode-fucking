package com.solve.leetcode.editor.cn;

import java.util.*;

class IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new IsomorphicStrings().new Solution();
        solution.isIsomorphic("bbbaaaba", "aaabbbba");
    }

    /**
     * 同构字符串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            HashMap<Character,Character> st = new HashMap<>(s.length());
            HashMap<Character,Character> ts = new HashMap<>(t.length());
            for (int i = 0; i < s.length(); i++) {
                if (st.containsKey(s.charAt(i)) && st.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
                st.put(s.charAt(i), t.charAt(i));
                if (ts.containsKey(t.charAt(i)) && ts.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
                ts.put(t.charAt(i), s.charAt(i));
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
