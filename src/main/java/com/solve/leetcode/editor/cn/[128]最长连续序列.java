package com.solve.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        solution.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3});
    }

    /**
     * 最长连续序列
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int max = 1;
            TreeSet<Integer> hash = new TreeSet<>();
            for (int num : nums) {
                hash.add(num);
            }
            int index = 1;
            int begin = 0;
            int i = 0;
            for (int num : hash) {
                if (i == 0) {
                    begin = num;
                    i++;
                    continue;
                }
                if (num - begin == 1) {
                    begin = num;
                    index++;
                } else {
                    index = 1;
                    begin = num;
                }
                max = Math.max(index, max);
                i++;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
