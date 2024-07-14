//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 1218 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 * @author wuou
 * @date 2024-07-14 21:05:50
 */
class P90_SubsetsIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P90_SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{1,2,2});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /**
         * 有相同元素出现
         * 先进行排序
         * 将相同的数字进行排序到一起
         */
        Arrays.sort(nums);
        dfs(nums,0);
        return ans;
    }

    private void dfs(int[] nums, int u) {
        if (u == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        int k = u + 1;
        while (k < nums.length && nums[k] == nums[u]) {
            k++;
        }
        for (int i = 0; i <= k - u; i++) {
            dfs(nums, k);
            path.add(nums[u]);
        }
        for (int i = 0; i <= k - u; i++) {
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}