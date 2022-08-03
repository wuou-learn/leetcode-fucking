package com.solve.leetcode.editor.cn;

/**
 * @author ouwu
 */
class FibonacciNumber {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber().new Solution();
        solution.fib(3);
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
            if (n == 1 || n == 2) {
                return 1;
            }
            int dp1 = 0; int dp2 = 1;
            int dpi = 0;
            for (int i = 2; i <= n; i++) {
                dpi = dp1 + dp2;
                dp1 = dp2;
                dp2 = dpi;
            }
            return dpi;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}
