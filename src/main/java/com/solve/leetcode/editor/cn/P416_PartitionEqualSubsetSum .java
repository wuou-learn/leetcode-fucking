//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 2041 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 分割等和子集
 * @author wuou
 * @date 2024-03-28 21:00:10
 */
class P416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P416_PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1,2,3,5});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n % 2 == 1) {
            return false;
        }
        int m = 0;
        for (int x : nums) {
            m += x;
        }
        m /= 2;
        boolean [] dp = new boolean[m+1];
        dp[0] = true;
        for (int x : nums) {
            for (int j = m; j >= x; j--) {
                dp[j] = dp[j] | dp[j-x];
            }
        }
        return dp[m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}