package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        solution.intersect(new int[]{1,2,2,1}, new int[]{2});
    }

    /**
     * 两个数组的交集 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> hash1 = new HashMap<>();

            for (int num : nums1) {
                hash1.put(num, hash1.getOrDefault(num,0)+1);
            }

            Map<Integer, Integer> hash2 = new HashMap<>();

            for (int num : nums2) {
                hash2.put(num, hash2.getOrDefault(num,0)+1);
            }

            List<Integer> list = new ArrayList<>();

            for (Map.Entry<Integer,Integer> entry : hash1.entrySet()) {
                if (!hash2.containsKey(entry.getKey())) {
                    continue;
                }
                Integer value2 = hash2.get(entry.getKey());
                for (int i =0; i < Math.min(entry.getValue(), value2); i++) {
                    list.add(entry.getKey());
                }
            }

            int [] res = new int[list.size()];
            for (int i = 0 ; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
