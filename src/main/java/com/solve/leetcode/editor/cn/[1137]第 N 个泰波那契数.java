package com.solve.leetcode.editor.cn;

class NThTribonacciNumber {
    public static void main(String[] args) {
        Solution solution = new NThTribonacciNumber().new Solution();
    }

    /**
     * 第 N 个泰波那契数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            int a = 0, b = 1,c = 1, ai = 0;
            for (int i = 3; i <= n; i++) {
                ai = a + b + c;
                a = b;
                b = c;
                c = ai;
            }
            return ai;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
