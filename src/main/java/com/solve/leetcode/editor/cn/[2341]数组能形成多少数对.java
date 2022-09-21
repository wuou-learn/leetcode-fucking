package com.solve.leetcode.editor.cn;

class MaximumNumberOfPairsInArray {
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfPairsInArray().new Solution();
    }

    /**
     * 数组能形成多少数对
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            int [] res = new int[2];
            int [] dict = new int[101];
            for (int num : nums) {
                dict[num]++;
            }
            for (int num : dict) {
                if (num != 0) {
                    res[0] += num/2;
                    res[1] += num%2;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
