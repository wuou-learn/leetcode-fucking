package com.solve.leetcode.editor.cn;

class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        solution.strStr("mississippi", "issip");
    }

    /**
     * 实现 strStr()
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }

            if (!haystack.contains(needle)) {
                return -1;
            }

            int m = haystack.length();

            int left = 0;
            int right = 0;
            int res = 0;
            while (m-left > right) {
                for (int i = left; i < haystack.length() && right < needle.length(); i++) {
                    if (haystack.charAt(i) == needle.charAt(right)) {
                        right++;
                    } else {
                        break;
                    }
                    if (right == needle.length()) {
                        res = i;
                        break;
                    }
                }
                if (right == needle.length()) {
                    break;
                } else {
                    left++;
                    right = 0;
                }
            }
            return res-needle.length()+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
