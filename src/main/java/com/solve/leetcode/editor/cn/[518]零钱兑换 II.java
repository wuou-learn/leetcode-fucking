package com.solve.leetcode.editor.cn;

import java.util.Arrays;

class CoinChange2 {
    public static void main(String[] args) {
        Solution solution = new CoinChange2().new Solution();
        solution.change(5,new int[]{1,2});
    }

    /**
     * 零钱兑换 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int change(int amount, int[] coins) {
            // 共有多少种方式
            int [] dp = new int [amount+1];
            dp[0] = 1;
            for (int i = 0; i < coins.length; i++) {
                for (int j = coins[i]; j <= amount; j++) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
            
            return dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
