package com.solve.leetcode.editor.cn;

class TargetSum {
    public static void main(String[] args) {
        Solution solution = new TargetSum().new Solution();
        solution.findTargetSumWays(new int[]{1000}, -1000);
    }

    /**
     * 目标和
     *
     *
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            if (nums.length == 1 && Math.abs(nums[0]) != Math.abs(target)) {
                return 0;
            }
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum < target || (target+sum) % 2 ==1) {
                return 0;
            }

            int len = (target+sum) / 2;
            int [] dp = new int[len+1];
            dp[0] = 1;
            for (int num : nums) {
                for (int j = len; j >= num ; j--) {
                    dp[j] = dp[j] + dp[j-num];
                }
            }
            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
