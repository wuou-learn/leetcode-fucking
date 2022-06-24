//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics数组 | 数学 | 排序 
//
// 👍 382, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class MaximumProductOfThreeNumbers {
    public static void main(String[] args) {
        Solution solution = new MaximumProductOfThreeNumbers().new Solution();
        solution.maximumProduct(new int[]{-1,-2,-3,-4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 时间复杂度O(n)
         * 空间 O(1)
         */
        Long min = Long.MIN_VALUE;
        public int maximumProduct(int[] nums) {
            long a=min,b=min,c=min;
            long d=Long.MAX_VALUE,f=Long.MAX_VALUE;
            for (int x : nums) {
                if (x > a) {
                    c=b;
                    b=a;
                    a=x;
                } else if (x > b) {
                    c=b;
                    b=x;
                } else if (x > c) {
                    c=x;
                }

                if (x < d) {
                    f = d;
                    d = x;
                } else if (x < f) {
                    f = x;
                }
            }
            return (int) Math.max(a*b*c,d*f*a);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}