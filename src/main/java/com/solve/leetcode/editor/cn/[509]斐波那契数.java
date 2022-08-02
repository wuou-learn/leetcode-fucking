package com.solve.leetcode.editor.cn;

/**
 * @author ouwu
 */
class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        solution.fib(0);
    }

    /**
     * 斐波那契数
     */
//leetcode submit region begin(Prohibit modification and deletion)
    /*class Solution {
        public int fib(int n) {
            if (n == 0) return 0;
            int [] arr = new int[n+1];
            return inner(n,arr);
        }
        public int inner(int n,int [] arr) {
            if (n == 1 || n == 2) {
                return 1;
            }
            if (arr[n] != 0) {
                return arr[n];
            }
            arr[n] = inner(n - 1, arr) + inner(n - 2, arr);
            return arr[n];
        }
    }*/

    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            int [] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }
            return dp[n];
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
