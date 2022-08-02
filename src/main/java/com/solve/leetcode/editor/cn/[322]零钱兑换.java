package com.solve.leetcode.editor.cn;

import java.util.Arrays;

class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        solution.coinChange(new int[]{1,2,5}, 3);
    }

    /**
     * 零钱兑换
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int [] memo ;
        public int coinChange(int[] coins, int amount) {
            memo = new int[amount+1];
            Arrays.fill(memo, -888);
            return dp(coins,amount);
        }

        private int dp(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            if (amount < 0) {
                return -1;
            }
            if (memo[amount] != -888) {
                return memo[amount];
            }
            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                int dp = dp(coins, amount-coin);
                if (dp < 0) {
                    continue;
                }
                res = Math.min(dp+1, res);
            }
            memo[amount] = res==Integer.MAX_VALUE ? -1 : res;
            return memo[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
