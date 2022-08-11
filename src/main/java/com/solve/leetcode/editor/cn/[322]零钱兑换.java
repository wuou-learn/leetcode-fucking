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
        public int coinChange(int[] coins, int amount) {
            int [] dp = new int [amount+1];
            Arrays.fill(dp, amount+1);
            dp[0] = 0;
            for (int i = 0; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
            return dp[amount] == amount+1?-1:dp[amount];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
