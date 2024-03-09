//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1546 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 全排列 II
 * @author wuou
 * @date 2024-03-07 20:51:18
 */
class P47_PermutationsIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P47_PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1,1,2});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean [] b;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        b = new boolean[nums.length];
        dfs(nums, 0);
        return ans;
    }
    public void dfs(int [] nums, int u) {
        if (u == nums.length) {
            ans.add(new ArrayList<>(path));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!b[i]) {
                if (i > 0 && nums[i-1] == nums[i] && !b[i-1]) {
                    continue;
                }
                path.add(nums[i]);
                b[i] = true;
                dfs(nums, u+1);
                b[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}