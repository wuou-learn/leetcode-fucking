package com.solve.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Solution solution = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().new Solution();
    }

    /**
     * 绝对差不超过限制的最长连续子数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            int res = Integer.MIN_VALUE;
            int len = nums.length;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {



                deque.clear();
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
