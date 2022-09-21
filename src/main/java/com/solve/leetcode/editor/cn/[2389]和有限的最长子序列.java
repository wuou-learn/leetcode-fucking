package com.solve.leetcode.editor.cn;

import java.util.Arrays;

class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        Solution solution = new LongestSubsequenceWithLimitedSum().new Solution();
        solution.answerQueries(new int[]{469781, 45635, 628818, 324948, 343772, 713803, 452081}, new int[]{816646, 929491});

    }

    /**
     * 和有限的最长子序列
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] answerQueries(int[] nums, int[] queries) {
            int[] res = new int[queries.length];
            Arrays.sort(nums);
            for (int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            for (int i = 0; i < queries.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] <= queries[i]) {
                        res[i] = j + 1;
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
