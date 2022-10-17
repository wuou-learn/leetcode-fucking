package com.solve.leetcode.editor.cn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
    }

    /**
     * 四数之和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i -1]) {
                    continue;
                }
                for (int j = i+1; j < nums.length; j++) {
                    if (j > i+1 && nums[j] == nums[j -1]) {
                        continue;
                    }
                    for (int k = j + 1, u = nums.length-1; k < u; k++) {
                        if (k > j + 1 && nums[k] == nums[k - 1]) {
                            continue;
                        }
                        while (u-1 > k && nums[i] + nums[j] +nums[k] + nums[u-1] >= target) {
                            u--;
                        }
                        BigDecimal sum = new BigDecimal(nums[i]).add(new BigDecimal(nums[j])).add(new BigDecimal(nums[k])).add(new BigDecimal(nums[u]));

                        if (sum.longValue() == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[u]);
                            res.add(list);
                        }
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
