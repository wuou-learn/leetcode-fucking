//给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。 
//
// 请你返回你需要移除的最短子数组的长度，如果无法满足题目要求，返回 -1 。 
//
// 子数组 定义为原数组中连续的一组元素。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,1,4,2], p = 6
//输出：1
//解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [6,3,5,2], p = 9
//输出：2
//解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。
// 
//
// 示例 3： 
//
// 输入：nums = [1,2,3], p = 3
//输出：0
//解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。
// 
//
// 示例 4： 
//
// 输入：nums = [1,2,3], p = 7
//输出：-1
//解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。
// 
//
// 示例 5： 
//
// 输入：nums = [1000000000,1000000000,1000000000], p = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= p <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 268 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 使数组和能被 P 整除
 * @author wuou
 * @date 2025-09-08 15:54:43
 */
class P1590_MakeSumDivisibleByP{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1590_MakeSumDivisibleByP().new Solution();
        solution.minSubarray(new int[]{1000000000,1000000000,1000000000}, 3);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long mod = sum % p;
        if (mod == 0) {
            return 0;
        }
        int ans = nums.length;

        // (sum[i] - (prefix[i] - prefix[j])) % p == 0
        // sum % p = (prefix[i] - prefix[j]) % p
        // 设 mod = sum % p
        // mod = (prefix[r] - prefix[l - 1]) % p
        // mod = prefix[r] % p - prefix[l - 1] % p
        // prefix[l - 1] % p = prefix[r] % p - mod
        // prefix[l - 1] % p = prefix[r] % p - (sum % p)
        // prefix[l - 1] % p = (prefix[r] - sum) % p
        // 根据欧几里得除法可得 sum = q*p + mod
        // prefix[l - 1] % p = (prefix[r] - (q*p + mod)) % p
        // prefix[l - 1] % p = (prefix[r] - mod) % p
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        long prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            long curMod = prefix % p;
            long need = (curMod - mod + p) % p;
            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }
            map.put(curMod, i);
        }
        return ans == nums.length ? -1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}