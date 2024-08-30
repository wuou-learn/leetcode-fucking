//给你一个下标从 0 开始的整数数组 nums 和一个整数 target 。 
//
// 返回和为 target 的 nums 子序列中，子序列 长度的最大值 。如果不存在和为 target 的子序列，返回 -1 。 
//
// 子序列 指的是从原数组中删除一些或者不删除任何元素后，剩余元素保持原来的顺序构成的数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5], target = 9
//输出：3
//解释：总共有 3 个子序列的和为 9 ：[4,5] ，[1,3,5] 和 [2,3,4] 。最长的子序列是 [1,3,5] 和 [2,3,4] 。所以答案为
// 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,1,3,2,1,5], target = 7
//输出：4
//解释：总共有 5 个子序列的和为 7 ：[4,3] ，[4,1,2] ，[4,2,1] ，[1,1,5] 和 [1,3,2,1] 。最长子序列为 [1,3,
//2,1] 。所以答案为 4 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5,4,5], target = 3
//输出：-1
//解释：无法得到和为 3 的子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 1 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 33 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 和为目标值的最长子序列的长度
 * @author wuou
 * @date 2024-08-29 10:07:34
 */
class P2915_LengthOfTheLongestSubsequenceThatSumsToTarget{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2915_LengthOfTheLongestSubsequenceThatSumsToTarget().new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        solution.lengthOfLongestSubsequence(list, 3);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;
    List<Integer> path = new ArrayList<>();
    int[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        // f(i,j) 前i个数和最大为j
        memo = new int[nums.size() + 1][target + 1];
        for (int i = 0; i < nums.size() + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                memo[i][j] = -1;
            }
        }
        dfs(0, nums, target);
        return res == 0 ? -1 : res;
    }

    private void dfs(int u, List<Integer> nums, int target) {
        Integer sum = path.stream().reduce(Integer::sum).orElse(0);
        if (sum > target) {
            return;
        }
        if (memo[u][sum] == -1) {
            memo[u][sum] = Math.max(res, path.size());
        } else {
            if (sum == target) {
                res = Math.max(res, path.size());
            }
            memo[u][sum] = res;
        }
        for (int i = u; i < nums.size(); i++) {
            path.add(nums.get(i));
            dfs(i + 1, nums, target);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}