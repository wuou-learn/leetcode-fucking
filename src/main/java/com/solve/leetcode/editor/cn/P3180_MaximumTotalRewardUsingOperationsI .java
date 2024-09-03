//给你一个整数数组 rewardValues，长度为 n，代表奖励的值。 
//
// 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ： 
//
// 
// 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。 
// 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + 
//rewardValues[i]），并 标记 下标 i。 
// 
//
// 以整数形式返回执行最优操作能够获得的 最大 总奖励。 
//
// 
//
// 示例 1： 
//
// 
// 输入：rewardValues = [1,1,3,3] 
// 
//
// 输出：4 
//
// 解释： 
//
// 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。 
//
// 示例 2： 
//
// 
// 输入：rewardValues = [1,6,4,3,2] 
// 
//
// 输出：11 
//
// 解释： 
//
// 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。 
//
// 
//
// 提示： 
//
// 
// 1 <= rewardValues.length <= 2000 
// 1 <= rewardValues[i] <= 2000 
// 
//
// Related Topics 数组 动态规划 👍 10 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 执行操作可获得的最大总奖励 I
 * @author wuou
 * @date 2024-08-31 17:55:56
 */
class P3180_MaximumTotalRewardUsingOperationsI{
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P3180_MaximumTotalRewardUsingOperationsI().new Solution();
//        solution.maxTotalReward(new int[]{1,6,4,3,2});
        String a1 = "a1";
        char[] charArray = a1.toCharArray();
        System.out.println(charArray[0] - 'a');
        System.out.println('8' - charArray[1]);
        a1 = "a3";
        charArray = a1.toCharArray();
        System.out.println(charArray[0] - 'a');
        System.out.println('8' - charArray[1]);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;
    public int maxTotalReward(int[] r) {
        Arrays.sort(r);
        dfs(0,0,r);
        return res;
    }
    private void dfs(int u, int x, int[] r) {
        String c1 = "";
        boolean b1 = false;
        boolean b2 = false;
        if (b1 == b2) {

        }
        if (u >= r.length) {
            res = Math.max(res, x);
            return;
        }
        for (int i = u; i < r.length; i++) {
            // 选
            if (r[i] > x) {
                dfs(i + 1, x + r[i], r);
            } else {
                // 不选
                dfs(i + 1, x, r);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}