//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics数组 | 哈希表 
//
// 👍 1504, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.jar.Pack200;

public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new FirstMissingPositive().new Solution();
        solution.firstMissingPositive(new int[]{3,4,-1,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 41
         * @param nums
         * @return
         */
        public int firstMissingPositive(int[] nums) {
            // hash
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= 0) {
                    nums[i] = n+1;
                }
            }

            for (int i =0; i<n; i++) {
                int x = Math.abs(nums[i]);
                if (x <= n) {
                    nums[x -1] = -Math.abs(nums[x-1]);
                }
            }
            for (int i =0; i<n; i++) {
                if (nums[i] >= 0) {
                    return i+1;
                }
            }
            return n+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}