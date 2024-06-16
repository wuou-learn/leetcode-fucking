//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5181 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Stack;

/**
 * 接雨水
 * @author wuou
 * @date 2024-06-06 20:19:29
 */
class P42_TrappingRainWater{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P42_TrappingRainWater().new Solution();
        solution.trap(new int[]{4,2,0,3});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int last = 0;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[i] > height[stk.peek()]) {
                res += (height[stk.peek()] - last) * (i - 1 - stk.peek());
                last = height[stk.pop()];
            }
            if (!stk.isEmpty()) {
                res += (height[i] - last) * (i - 1 - stk.peek());
            }
            stk.push(i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}