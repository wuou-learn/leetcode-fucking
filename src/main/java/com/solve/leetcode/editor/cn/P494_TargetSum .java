//给你一个非负整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1879 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 目标和
 * @author wuou
 * @date 2024-03-17 20:53:16
 */
class P494_TargetSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P494_TargetSum().new Solution();
        solution.findTargetSumWays(new int[]{1}, 2);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int offset = 1000;
        int [][] dp = new int[nums.length + 1][2001];
        dp[0][offset] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = -offset; j <= offset; j++) {
                // 需要满足 j - nums[i-1] + offset >= 0
                if (j - nums[i-1] >= -offset) {
                    dp[i][j + offset] += dp[i-1][j - nums[i-1] + offset];
                }
                // 需要满足 j + nums[i-1] + offset >= 0
                if (j + nums[i-1] <= offset) {
                    dp[i][j + offset] += dp[i-1][j + nums[i-1] + offset];
                }
            }
        }
        return dp[nums.length][target + offset];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}