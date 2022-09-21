package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class NumberOfArithmeticTriplets {
    public static void main(String[] args) {
        Solution solution = new NumberOfArithmeticTriplets().new Solution();
    }

    /**
     * 算术三元组的数目
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int res = 0;
            for (int num : nums) {
                if (set.contains(num+diff) && set.contains(num+(diff*2))) {
                    res++;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
