package com.solve.leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
    }

    /**
     * 存在重复元素 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            // 值-index
            HashMap<Integer, List<Integer>> hash = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                if (hash.containsKey(nums[i])) {
                    List<Integer> list = hash.get(nums[i]);
                    list.add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    hash.put(nums[i], list);
                }
            }

            for (Map.Entry<Integer,List<Integer>> entry : hash.entrySet()) {
                if (entry.getValue().size() <= 1) {
                    continue;
                }
                List<Integer> index = entry.getValue();
                for (int i = 0; i < index.size(); i++) {
                    for (int j = i+1; j < index.size(); j++) {
                        if (Math.abs(index.get(i) - index.get(j)) <= k) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
