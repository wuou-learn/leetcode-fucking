//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2826 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 全排列
 * @author wuou
 * @date 2024-03-07 20:37:25
 */
class P46_Permutations{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P46_Permutations().new Solution();
        solution.permute(new int[]{1,2,3});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(nums, new ArrayList<>(), res, new boolean[nums.length]);

        return res;
    }

    private void dfs(int[] nums, ArrayList<Integer> path, List<List<Integer>> res, boolean[] used) {

        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            dfs(nums, path, res, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}