package com.solve.leetcode.editor.cn;

class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new MinCostClimbingStairs().new Solution();
    }

    /**
     * 使用最小花费爬楼梯
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int [] dp = new int [cost.length+1];
            for (int i = 2; i <= cost.length; i++) {
                dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
            }
            return dp[cost.length];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
