//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2257 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * @author wuou
 * @date 2024-03-05 22:34:46
 */
class P78_Subsets{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P78_Subsets().new Solution();
        solution.subsets(new int[]{0,1,2});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums,0);
        return ans;
    }
    private void dfs(int [] nums, int u) {
        ans.add(new ArrayList<>(path));
        for (int i = u; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, i+1);
            path.remove(path.size()-1);
        }
    }

    /*public void dfs(int[] nums, int u) {
        if (u == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不放nums[u]
        dfs(nums, u+1);
        // 放nums[u]
        path.add(nums[u]);
        dfs(nums,u+1);
        path.remove(path.size() - 1);
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)

}