//一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被
//小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：nums = [2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// 
//
// 
// 注意：本题与主站 198 题相同： https://leetcode-cn.com/problems/house-robber/ 
//
// Related Topics 数组 动态规划 👍 58 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 打家劫舍
 * @author wuou
 * @date 2024-03-18 20:20:41
 */
class PLCR089_Gu0c2T{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new PLCR089_Gu0c2T().new Solution();
        solution.rob(new int[]{2,7,9,3,1});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int [] f = new int[nums.length+2];
        for (int i = 0; i < nums.length; i++) {
            f[i+2] = Math.max(f[i+1],f[i]+nums[i]);
        }
        return f[nums.length+1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}