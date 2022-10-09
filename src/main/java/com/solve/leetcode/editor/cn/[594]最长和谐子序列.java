package com.solve.leetcode.editor.cn;

import java.util.HashMap;

class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
    }

    /**
     * 最长和谐子序列
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            HashMap<Integer,Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num,map.getOrDefault(num,0) + 1);
            }
            int res = 0;
            for (int num : nums) {
                if (map.containsKey(num-1)) {
                    res = Math.max(map.get(num)+map.get(num-1), res);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
