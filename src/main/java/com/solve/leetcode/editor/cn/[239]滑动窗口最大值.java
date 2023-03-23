package com.solve.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{7,2,4}, 2);
    }

    /**
     * 滑动窗口最大值
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            List<Integer> list = new ArrayList<>();
            Deque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < nums.length; i++) {
                // 超出滑动窗口最大值 弹出队首
                if (!deque.isEmpty() && i - k + 1 > deque.peekFirst()) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.add(i);
                if (i >= k - 1) {
                    list.add(nums[deque.peekFirst()]);
                }
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
