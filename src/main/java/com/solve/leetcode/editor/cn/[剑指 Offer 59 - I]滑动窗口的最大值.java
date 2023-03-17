package com.solve.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class HuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    }

    /**
     * 滑动窗口的最大值
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int len = nums.length;
            int [] res = new int[len-k+1];
            Deque<Integer> deque = new ArrayDeque<>();
            int j = 0;
            for (int i = 0; i < len; i++) {
                if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                    deque.pollFirst();
                }

                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }

                deque.addLast(i);
                if (i >= k - 1 && Objects.nonNull(deque.peekFirst())) {
                    res[j++] = nums[deque.peekFirst()];
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
