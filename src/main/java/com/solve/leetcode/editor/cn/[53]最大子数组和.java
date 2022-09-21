package com.solve.leetcode.editor.cn;

class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        solution.maxSubArray(new int[]{-2,-1});
    }

    /**
     * 最大子数组和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public int maxSubArray(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int max = Integer.MIN_VALUE;
            int []dp = new int [nums.length+1];
            dp[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                int index = i;
                int j = 1;
                while(j <= nums.length && index > 0){
                    if (j == 1) {
                        dp[j] = nums[index - 1];
                    } else {
                        dp[j] = dp[j - 1] + nums[index - 1];
                    }
                    max = Math.max(dp[j], max);
                    j++;
                    index--;
                }
            }
            return max;
        }
    }*/

    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (j < 0) {
                    j = 0;
                }
                j += nums[i];
                max = Math.max(max, j);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
