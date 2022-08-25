package com.solve.leetcode.editor.cn;

class HouseRobber {
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();
        solution.rob(new int[]{2,1,1,2});
    }

    /**
     * 打家劫舍
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int []dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
            return dp[nums.length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
