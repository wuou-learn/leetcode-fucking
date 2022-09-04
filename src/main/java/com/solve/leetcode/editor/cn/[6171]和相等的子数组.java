package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class FindSubarraysWithEqualSum {
    public static void main(String[] args) {
        Solution solution = new FindSubarraysWithEqualSum().new Solution();
        solution.
                findSubarrays(new int[]{4,2,4});
    }

    /**
     * 和相等的子数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findSubarrays(int[] nums) {
            if (nums.length == 2) {
                return false;
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 1; i < nums.length; i++) {
                if (!set.add(nums[i-1] + nums[i])) {
                    return true;
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
