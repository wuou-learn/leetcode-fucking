//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1]
//输出：2
//说明：[0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0]
//输出：2
//说明：[0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 3： 
//
// 
//输入：nums = [0,1,1,1,1,1,0,0,0]
//输出：6
//解释：[1,1,1,0,0,0] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 803 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续数组
 * @author wuou
 * @date 2025-09-03 14:40:22
 */
class P525_ContiguousArray{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P525_ContiguousArray().new Solution();
        solution.findMaxLength(new int[]{0,1,1,0,1,1,1,0});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        // [0,1,1,1,1,1,0,0,0]
        // [-1 1 1 1 1 1 -1 -1 -1]
        // [-1 0 1 2 3 4  3  2  1]
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] == 0 ? -1 : 1;
            sum += num;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}