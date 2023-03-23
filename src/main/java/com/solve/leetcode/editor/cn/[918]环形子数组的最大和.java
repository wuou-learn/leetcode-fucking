package com.solve.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class MaximumSumCircularSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSumCircularSubarray().new Solution();
        solution.maxSubarraySumCircular(new int[]{-2});
    }

    /**
     * 环形子数组的最大和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int n = nums.length;
            int m = n << 1;
            int [] sum = new int[m+1];
            sum[0] = 0;
            for (int i = 1; i <= m; i++) {
                sum[i] = sum[i-1] + nums[(i-1) % n];
            }
            int res = Integer.MIN_VALUE;
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < sum.length; i++) {
                // 超出窗口长度弹出 队首
                if (!deque.isEmpty() && deque.peekFirst() < i - n) {
                    deque.pollFirst();
                }
                if (Objects.nonNull(deque.peekFirst())) {
                    res = Math.max(res, sum[i] - sum[deque.peekFirst()]);
                }
                // 最小的直接插队
                while (!deque.isEmpty() && sum[i] < sum[deque.peekLast()]) {
                    deque.pollLast();
                }

                deque.add(i);
            }

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
