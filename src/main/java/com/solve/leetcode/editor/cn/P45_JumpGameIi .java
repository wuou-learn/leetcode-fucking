//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2530 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 跳跃游戏 II
 * @author wuou
 * @date 2024-06-15 19:05:35
 */
class P45_JumpGameIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P45_JumpGameIi().new Solution();
        solution.jump(new int []{2,3,1,1,4});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] f = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            // j 是当前索引能跳最远的地方
            // j = 0 最远能跳至 2
            // j = 1 最远能跳至 4
            // 如果当前j达不到则++
            while (j + nums[j] < i) {
                j++;
            }
            // 达到i的位置最少需要多少步数
            //
            f[i] = f[j] + 1;
        }
        return f[n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}