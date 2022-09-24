package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class HappyNumber {
    public static void main(String[] args) {
        Solution solution = new HappyNumber().new Solution();
        solution.isHappy(19);
    }

    /**
     * 快乐数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isHappy(int n) {
            int fast = get(n);
            int slow = n;
            while (fast != slow) {
                fast = get(get(fast));
                slow = get(slow);
            }
            return fast == 1;
        }

        public int get(int x) {
            int res = 0;
            while (x != 0) {
                res += (x%10) * (x%10);
                x /= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
