//有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。 
//
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
// 
//
// 示例 2： 
//
// 
//输入：stones = [31,26,33,21,40]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 887 👎 0


package com.solve.leetcode.editor.cn;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 最后一块石头的重量 II
 * @author wuou
 * @date 2024-09-03 21:00:05
 */
class P1049_LastStoneWeightIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1049_LastStoneWeightIi().new Solution();
        solution.lastStoneWeightII(new int[]{31,26,33,21,40});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 问题的本质
     * 假设有一堆石头，它们的总重量为 S。我们希望通过不断地选择两块石头粉碎的方式，最终剩下最小重量的石头。
     * 为了理解这个问题，我们可以把它看成如何将这堆石头分成两堆，使得它们的重量差最小。
     * ●
     * 设 sum(A) 和 sum(B) 是这两堆石头的总重量。
     * ●
     * 我们知道：sum(A) + sum(B) = S。
     * 我们的目标是让 两堆石头的重量差最小，即最小化 |sum(A) - sum(B)|。
     * 推导
     * sub = ｜sumA - sumB｜
     * sumA + sumB = S
     * sumB = S - sumA
     * sub = ｜sumA - (S - sumA)｜
     * sub = ｜2 * sumA - S｜
     * 同：sub = S - 2 * sumA
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int s : stones) sum += s;
        int n = sum / 2;
        boolean[] f = new boolean[sum];
        f[0] = true;
        for (int s : stones) {
            for (int j = n; j >= s; j--) {
                f[j] = f[j] || f[j-s];
            }
        }
        for (int i = n; i >= 0; i--) {
            if (f[i]) {
                return sum - 2*i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}