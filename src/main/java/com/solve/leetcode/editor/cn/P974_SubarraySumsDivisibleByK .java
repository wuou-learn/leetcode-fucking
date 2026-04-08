//给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的非空 子数组 的数目。 
//
// 子数组 是数组中 连续 的部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,0,-2,-3,1], k = 5
//输出：7
//解释：
//有 7 个子数组满足其元素之和可被 k = 5 整除：
//[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
// 
//
// 示例 2: 
//
// 
//输入: nums = [5], k = 9
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 2 <= k <= 10⁴ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 556 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 * @author wuou
 * @date 2025-09-04 10:35:43
 */
class P974_SubarraySumsDivisibleByK{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P974_SubarraySumsDivisibleByK().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        // (sum[j] - sum[i]) % k == 0;
        // sum[j] % k == sum[i] % k
        // key = mod | value = 当前这个余数=mod的个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefix = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int mod = ((prefix % k) + k) % k;
            if (map.containsKey(mod)) {
                res += map.get(mod);
            }
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}