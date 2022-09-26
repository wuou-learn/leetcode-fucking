package com.solve.leetcode.editor.cn;

import java.util.HashMap;

class WordPattern {
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        solution.wordPattern("abba", "dog dog dog dog");
    }

    /**
     * 单词规律
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordPattern(String pattern, String s) {
            String[] strs = s.split(" ");
            if (pattern.length() != strs.length) {
                return false;
            }
            HashMap<Character,String> hashMap = new HashMap<>();
            for (int i = 0; i < pattern.length(); i++) {
                if (hashMap.containsKey(pattern.charAt(i))) {
                    String s1 = hashMap.get(pattern.charAt(i));
                    if (!s1.equals(strs[i])) {
                        return false;
                    }
                } else if (!hashMap.containsValue(strs[i])) {
                    hashMap.put(pattern.charAt(i), strs[i]);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
