//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1549 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II
 * @author wuou
 * @date 2024-06-05 20:16:07
 */
class P40_CombinationSumIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P40_CombinationSumIi().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(path, res, candidates, target, 0);
        return res;
    }

    private void dfs(List<Integer> path, List<List<Integer>> res, int[] candidates, int target, int u) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (u == candidates.length) {
            return;
        }
        int k = u + 1;
        while (k < candidates.length && candidates[k] == candidates[u]) {
            k ++;
        }
        // 当前数可用的次数
        int cnt = k - u;

        for (int i = 0; i <= cnt && candidates[u] * i <= target; i++) {
            dfs(path, res, candidates, target - candidates[u] * i, k);
            path.add(candidates[u]);
        }

        for (int i = 0; i <= cnt && candidates[u] * i <= target; i++) {
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}