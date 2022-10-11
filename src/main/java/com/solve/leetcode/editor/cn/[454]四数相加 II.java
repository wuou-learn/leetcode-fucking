package com.solve.leetcode.editor.cn;

import java.util.HashMap;

class FourSumIi {
    public static void main(String[] args) {
        Solution solution = new FourSumIi().new Solution();
    }

    /**
     * 四数相加 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int c : nums3) {
                for (int d : nums4) {
                    map.put(c+d, map.getOrDefault(c+d, 0)+1);
                }
            }
            int res = 0;
            for (int a : nums1) {
                for (int b : nums2) {
                    res += map.getOrDefault(-(a+b),0);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
