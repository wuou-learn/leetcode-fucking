package com.solve.leetcode.editor.cn;
class PartitionEqualSubsetSum{
  public static void main(String[] args) {
       Solution solution = new PartitionEqualSubsetSum().new Solution();
       solution.canPartition(new int[]{1,2,3,6});
  }
  /**
   * 分割等和子集
   */
  //leetcode submit region begin(Prohibit modification and deletion)
  public class Solution {

      public boolean canPartition(int[] nums) {
          int len = nums.length;
          int sum = 0;
          for (int num : nums) {
              sum += num;
          }
          if ((sum & 1) == 1) {
              return false;
          }

          int target = sum / 2;
          boolean[][] dp = new boolean[len][target + 1];

          // 初始化成为 true 虽然不符合状态定义，但是从状态转移来说是完全可以的
          dp[0][0] = true;

          if (nums[0] <= target) {
              dp[0][nums[0]] = true;
          }
          for (int i = 1; i < len; i++) {
              for (int j = 0; j <= target; j++) {
                  dp[i][j] = dp[i - 1][j];
                  if (nums[i] <= j) {
                      dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                  }
              }

              // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
              if (dp[i][target]) {
                  return true;
              }
          }
          return dp[len - 1][target];
      }
  }

//leetcode submit region end(Prohibit modification and deletion)

}
