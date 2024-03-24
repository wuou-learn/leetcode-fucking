//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
//
// Related Topics 数组 动态规划 👍 939 👎 0


package com.solve.leetcode.editor.cn;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 组合总和 Ⅳ
 * @author wuou
 * @date 2024-03-20 21:10:38
 */
class P377_CombinationSumIv{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P377_CombinationSumIv().new Solution();
        solution.combinationSum4(new int[]{1,2,3},4);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int path = 0;
    Map<Integer,Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        return dfs(target,nums);
    }
    public int dfs(int remain, int [] nums){
        if (remain == 0) {
            return 1;
        }
        if (map.containsKey(remain)) {
            return map.get(remain);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (remain >= nums[i]) {
                res += dfs(remain - nums[i], nums);
            }
        }
        map.put(remain, res);
        return res;
    }

    /*public int combinationSum4(int[] nums, int target) {
        int [] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i ++) {
            for (int v : nums) {
                if (i >= v) {
                    dp[i] += dp[i - v];
                }
            }
        }
        return dp[target];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}