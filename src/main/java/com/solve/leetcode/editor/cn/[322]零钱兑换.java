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
        /*int [] memo ;
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
        }*/

        public int coinChange(int[] coins, int amount) {
            int [] dp = new int[amount+1];
            Arrays.fill(dp, amount+1);
            // base case
            dp[0] = 0;

            for (int i = 0; i < dp.length; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
                }
            }
            return dp[amount] == amount+1 ? -1 : dp[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
