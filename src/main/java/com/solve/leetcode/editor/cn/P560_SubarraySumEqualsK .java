//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2406 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 和为 K 的子数组
 * @author wuou
 * @date 2024-07-22 19:06:28
 */
class P560_SubarraySumEqualsK{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P560_SubarraySumEqualsK().new Solution();
        solution.subarraySum(new int[]{1,1,1}, 2);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        // k = prefix[j] - prefix[i]
        // prefix[i] = prefix[j] - k
        // target = prefix[j] - k

        // key = 和  value = count
        Map<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int prefix = 0;
        int ans = 0;
        for (int num : nums) {
            prefix += num;
            int target = prefix - k;
            if (hash.containsKey(target)) {
                ans += hash.get(target);
            }
            hash.put(prefix, hash.getOrDefault(prefix, 0) + 1);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}