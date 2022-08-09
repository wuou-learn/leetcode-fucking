package com.solve.leetcode.editor.cn;

import java.util.Arrays;

class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        solution.lengthOfLIS(new int[]{0});
    }

    /**
     * 最长递增子序列
     *
     * 状态：在i个序列中 找出最长的序列
     *
     * 包含第i个
     * dp[i]
     * nums[j] > nums[i]
     * dp[i-1]+1
     *
     * 不包含第i个
     * dp[i] = dp[i-1] + 1
     *
     * 3  4  1  2  8  5  6
     * 1  2  1  2  3  3  4
     *
     * 状态计算
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            int [] dp = new int[length];
            Arrays.fill(dp, 1);
            int res = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j]+1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)
}
