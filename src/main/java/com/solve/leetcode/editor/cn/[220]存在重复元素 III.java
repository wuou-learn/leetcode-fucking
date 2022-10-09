package com.solve.leetcode.editor.cn;

import java.util.*;

class ContainsDuplicateIii {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIii().new Solution();
        solution.containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3,0);
    }

    /**
     * 存在重复元素 III
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            TreeSet<Long> ts = new TreeSet<>();
            for (int i = 0; i < nums.length; i++){
                Long u = (long) nums[i];
                // floor是小于等于u的第一个数
                Long f = ts.floor(u);
                if (f != null && u - f <= valueDiff) {
                    return true;
                }

                // ceiling是大于等于u的第一个数
                Long c = ts.ceiling(u);
                if (c != null && c - u <= valueDiff) {
                    return true;
                }

                ts.add(u);
                //滑动窗口将前面的数删除
                if (i >= indexDiff) {
                    ts.remove((long) nums[i - indexDiff]);
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
