package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }

    /**
     * 两个数组的交集
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            int[] hash = new int[1001];
            for (int num : nums1) {
                if (hash[num % 1000] >= 1) {
                    continue;
                }
                hash[num % 1000] = ++hash[num % 1000];
            }
            for (int num : nums2) {
                if (hash[num % 1000] >= 1) {
                    hash[num % 1000] = ++hash[num % 1000];
                }
            }
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 1001; i++) {
                if (hash[i] > 1) {
                    list.add(i);
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
