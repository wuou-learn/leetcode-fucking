package com.solve.leetcode.editor.cn;

class CheckDistancesBetweenSameLetters {
    public static void main(String[] args) {
        Solution solution = new CheckDistancesBetweenSameLetters().new Solution();
        solution.checkDistances("abaccb", new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    }

    /**
     * 检查相同字母间的距离
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkDistances(String s, int[] distance) {
            if (s.length() == 2) {
                return distance[s.charAt(0)%'a'] == 0;
            }
            int left = 0;
            int right = 1;
            while (left < right && left < s.length()-1) {
                if (right >= s.length()) {
                    left++;
                    right = left+1;
                    continue;
                }
                if (s.charAt(left) != s.charAt(right)) {
                    right++;
                } else {
                    int dis = right-left-1;
                    if (distance[s.charAt(left)%'a'] != dis) {
                        return false;
                    }
                    left++;
                    right = left+1;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
