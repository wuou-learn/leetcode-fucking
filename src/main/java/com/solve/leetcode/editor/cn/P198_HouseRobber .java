//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
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
// Related Topics 数组 动态规划 👍 2942 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 打家劫舍
 * @author wuou
 * @date 2024-03-17 16:13:37
 */
class P198_HouseRobber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P198_HouseRobber().new Solution();
        solution.rob(new int[]{1,2,3,1});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        int f0=0,f1=0;
        int res;
        for (int i = 0; i < n; i++) {
            res = Math.max(f0+nums[i], f1);
            f0 = f1;
            f1 = res;
        }
        return f1;
    }
    /*
    // O(n)
    public int rob(int[] nums) {
        int n = nums.length;
        int [] f = new int[n+2];

        for (int i = 0; i < n; i++) {
            f[i+2] = Math.max(f[i]+nums[i], f[i+1]);
        }
        return f[n+1];
    }*/
    /*

    int [] path;
    public int rob(int[] nums) {
        int n = nums.length;
        path = new int[n];
        Arrays.fill(path, -1);
        return dfs(n-1,nums);
    }
    public int dfs(int u, int[] nums) {
        if (u < 0) {
            return 0;
        }
        if (path[u] != -1) {
            return path[u];
        }
        int max = Math.max(dfs(u - 1, nums), dfs(u - 2, nums) + nums[u]);
        path[u] = max;
        return max;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}