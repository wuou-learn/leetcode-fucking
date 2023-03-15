package com.solve.leetcode.editor.cn;

import java.util.*;

class NextGreaterElementIi {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIi().new Solution();
        solution.nextGreaterElements(new int[]{5,2,3});
    }

    /**
     * 下一个更大元素 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int length = nums.length;
            Stack<Integer> stack = new Stack<>();
            int [] arr = new int[length*2];
            for (int i = 0; i < length; i++) {
                arr[i] = nums[i];
                arr[i+length] = nums[i];
            }
            int [] res = new int[length];
            for (int i = length * 2 - 1; i >= 0; i--) {
                while (!stack.empty() && arr[i] >= stack.peek()) {
                    stack.pop();
                }
                if (i < length) {
                    if (stack.empty()) {
                        res[i] = -1;
                    } else {
                        res[i] = stack.peek();
                    }
                }
                stack.push(arr[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
