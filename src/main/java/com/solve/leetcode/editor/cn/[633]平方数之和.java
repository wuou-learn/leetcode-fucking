package com.solve.leetcode.editor.cn;

class SumOfSquareNumbers {
    public static void main(String[] args) {
        Solution solution = new SumOfSquareNumbers().new Solution();
        solution.judgeSquareSum(3);
    }

    /**
     * 平方数之和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgeSquareSum(int c) {
            for (long i = 0L; i * i <= c; i++) {
                long j = c - (i * i);
                double sqrt = Math.sqrt(j);
                if ((int) sqrt * sqrt == j) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
