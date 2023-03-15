package com.solve.leetcode.editor.cn;

import java.util.Stack;

class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        solution.trap(new int[]{4,2,0,3,2,5});

    }

    /**
     * 接雨水
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            Stack<Integer> stk = new Stack<>();
            int res = 0;
            int last = 0;
            for (int i = 0; i < height.length; i++) {
                while (!stk.empty() && height[i] >= height[stk.peek()]) {
                    res += (i - 1 - stk.peek()) * (height[stk.peek()] - last);
                    last = height[stk.peek()];
                    stk.pop();
                }
                if (!stk.empty()) {
                    res += (i - 1 - stk.peek()) * (height[i] - last);
                }
                stk.push(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
