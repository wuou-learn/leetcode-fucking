//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 输入 保证 数组 answer[i] 在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 2000 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 除自身以外数组的乘积
 * @author wuou
 * @date 2025-04-03 16:13:04
 */
class P238_ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P238_ProductOfArrayExceptSelf().new Solution();
        solution.productExceptSelf(new int[]{1,2,3,4});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1 2 3 4 => 1 2 6 24
        // 1 2 3 4 => 24 24 12 4
        int [] l = new int[nums.length];
        l[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            l[i] = nums[i] * l[i - 1];
        }

        int [] r = new int[nums.length];
        r[nums.length - 1] = nums[nums.length - 1];
        for (int j = nums.length - 2; j >= 0; j--) {
            r[j] = nums[j] * r[j + 1];
        }

        int [] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int left = i > 0 ? l[i - 1] : 1;
            int right = i >= nums.length - 1 ? 1 : r[i + 1];
            ans[i] = left * right;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}