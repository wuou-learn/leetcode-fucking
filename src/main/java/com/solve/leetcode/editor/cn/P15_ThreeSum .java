//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6871 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * @author wuou
 * @date 2024-05-15 20:24:23
 */
class P15_ThreeSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P15_ThreeSum().new Solution();
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先进行排序
        // 双指针一定需要数组是有序的
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果值相同 则i去重
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1, k = nums.length - 1; j < k; j++) {
                // 如果值相同 则j去重
                // j > i + 1 确保j 是紧跟i之后的指针
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                // j < k - 1 避免指针j与k 重复
                // nums[i] + nums[j] + nums[k - 1] >= 0 因为数组是有序的 所以 nums[i] + nums[j] + nums[k] 也必然大于等于0
                // 循环该过程 必然能找到一个接近于零的 k 值
                while (j < k - 1 && nums[j] + nums[i] + nums[k-1] >= 0) k--;
                if (nums[j] + nums[i] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}