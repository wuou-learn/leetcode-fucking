//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics数组 | 排序 
//
// 👍 367, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        solution.thirdMax(new int[]{5,2,3});
    }

    /**
     * 解法一： treeMap
     * 时间复杂度 O(N)
     * 空间复杂度 O(N)
     * TreeSet<Integer> treeSet = new TreeSet<>();
     *             for (int n : nums) {
     *                 treeSet.add(n);
     *             }
     * return treeSet.size()>3?treeSet.last():treeSet.first();
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度 O(N)
         * 空间复杂度 O(1)
         * @param nums
         * @return
         */
        Long inf = Long.MIN_VALUE;
        public int thirdMax(int[] nums) {
            long a= inf,b= inf,c= inf;
            for (int i : nums) {
                if (i > a) {
                    c = b;
                    b = a;
                    a = i;
                } else if (i > b && i < a) {
                    c = b;
                    b = i;
                } else if (i > c && i < b) {
                    c = i;
                }
            }
            return c != inf ? (int)c : (int)a;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}