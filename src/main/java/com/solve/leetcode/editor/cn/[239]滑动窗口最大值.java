package com.solve.leetcode.editor.cn;

import java.util.*;

class SlidingWindowMaximum {
    public static void main(String[] args) {
        Solution solution = new SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }

    /**
     * 滑动窗口最大值
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int length = nums.length;
            List<Integer> list = new ArrayList<>();
            Deque<Integer> deque = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                // 如果超过窗口长度弹出队头
                if (!deque.isEmpty() && deque.peekFirst() < i - k +1) {
                    deque.pollFirst();
                }

                // 比较尾节点是否是最大的 如果最大直接插队
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }

                // 插入
                deque.addLast(i);
                if (i >= k -1 && Objects.nonNull(deque.peekFirst())) {
                    list.add(nums[deque.peekFirst()]);
                }
            }
            int [] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
