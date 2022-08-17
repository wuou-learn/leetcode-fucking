package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PerfectSquares{
  public static void main(String[] args) {
       Solution solution = new PerfectSquares().new Solution();
      solution.numSquares(12);
  }
  /**
   * 完全平方数
   */
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i*i <= n; i++) {
            list.add(i*i);
        }

        int dp[] = new int [n+1];
        Arrays.fill(dp, n+1);
        dp[0]=0;
        for (Integer num : list) {
            for (int i = num; i < n+1; i++) {
                dp[i] = Math.min( dp[i], dp[i-num] + 1 );
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
