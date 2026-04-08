//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
//
// Related Topics 数组 哈希表 前缀和 滑动窗口 👍 364 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 和相同的二元子数组
 * @author wuou
 * @date 2025-09-08 11:19:20
 */
class P930_BinarySubarraysWithSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P930_BinarySubarraysWithSum().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // prefix[j] − prefix[i]=goal
        // prefix[i] = prefix[j] - goal;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            if (map.containsKey(prefix - goal)) {
                ans += map.get(prefix - goal);
            }
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}