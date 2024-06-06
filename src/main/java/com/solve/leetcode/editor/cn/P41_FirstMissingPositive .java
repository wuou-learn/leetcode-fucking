//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
//解释：1 在数组中，但 2 没有。 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
//解释：最小的正数 1 没有出现。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 2134 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashSet;

/**
 * 缺失的第一个正数
 * @author wuou
 * @date 2024-06-05 21:06:47
 */
class P41_FirstMissingPositive{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P41_FirstMissingPositive().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for (int i =0; i < nums.length; i++) {
            hash.add(nums[i]);
        }

        int i = 1;
        while (hash.contains(i)) {
            i++;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}