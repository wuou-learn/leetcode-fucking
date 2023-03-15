package com.solve.leetcode.editor.cn;

import java.util.*;

class NextGreaterElementI {
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementI().new Solution();
        solution.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }

    /**
     * 下一个更大元素 I
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int length = nums2.length;
            Deque<Integer> stack = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>(length);
            for (int i = length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    map.put(nums2[i], -1);
                }else {
                    map.put(nums2[i], stack.peek());
                }
                stack.push(nums2[i]);
            }
            int [] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
