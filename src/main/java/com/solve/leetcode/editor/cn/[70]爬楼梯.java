package com.solve.leetcode.editor.cn;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.FutureTask;

class ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs().new Solution();
    }

    /**
     * 爬楼梯
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {

            if (n == 1) {
                return 1;
            }
            //
            int a = 1, b = 1, r = 0;
            for (int i = 2; i <= n; i++) {
                r = a + b;
                a = b;
                b = r;
            }

            return r;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
