package com.solve.leetcode.editor.cn;


import java.util.*;

class KDiffPairsInAnArray {
    public static void main(String[] args) {
        Solution solution = new KDiffPairsInAnArray().new Solution();
        solution.findPairs(new int[]{3,1,4,1,5}, 2);
    }

    /**
     * 数组中的 k-diff 数对
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPairs(int[] nums, int k) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (Math.abs(nums[i] - nums[j]) == k) {
                        if (map.containsKey(nums[i])) {
                            if (map.getOrDefault(nums[j],Collections.emptySet()).contains(nums[i])) {
                                // 判断两个相反的值是否存在存在就不put
                                continue;
                            }
                            Set<Integer> integers = map.get(nums[i]);
                            integers.add(nums[j]);
                        }else {
                            if (map.getOrDefault(nums[j],Collections.emptySet()).contains(nums[i])) {
                                // 判断两个相反的值是否存在存在就不put
                                continue;
                            }
                            Set<Integer> set = new HashSet<>();
                            set.add(nums[j]);
                            map.put(nums[i], set);
                        }
                    }
                }
            }
            int res = 0;
            for (Set<Integer> set : map.values()) {
                res+=set.size();
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
