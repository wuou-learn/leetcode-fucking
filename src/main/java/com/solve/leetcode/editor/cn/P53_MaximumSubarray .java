//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 6691 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 最大子数组和
 * @author wuou
 * @date 2024-06-18 19:30:37
 */
class P53_MaximumSubarray{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P53_MaximumSubarray().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        // f(i) 表示所有nums[i] 结尾的区间中最大和是多少
        // f(i) 分成两个区间 区间长度>=2  区间长度=1
        // 枚举所有的区间  [i-1,i] [i-2,i] [i-3,i] [0,i]  =>  f(i-1)+nums[i]
        // 枚举一个数的区间
        // so: f(i) = max (nums[i], f(i-1)+nums[i])
        //          = nums[i] + max(f(i-1), 0);
        int res = Integer.MIN_VALUE;
        for (int i = 0, last = 0; i < nums.length; i++) {
            last = nums[i] + Math.max(last, 0);
            res = Math.max(last, res);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}