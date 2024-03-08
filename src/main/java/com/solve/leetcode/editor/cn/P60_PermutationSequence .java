//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
//
// Related Topics 递归 数学 👍 832 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 排列序列
 * @author wuou
 * @date 2024-03-08 22:18:45
 */
class P60_PermutationSequence{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P60_PermutationSequence().new Solution();
        solution.getPermutation(3,3);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    int[] path;
    boolean [] b;
    int i = 0;
    String res = "";
    public String getPermutation(int n, int k) {
        path = new int[n];
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        permuteUnique(nums,k);
        return res;
    }


    public void permuteUnique(int[] nums,int k) {
        b = new boolean[nums.length];
        dfs(nums, 0,k);
    }
    public void dfs(int [] nums, int u,int k) {
        if (!res.isEmpty()) {
            return;
        }
        if (u == nums.length && ++i == k) {
            res = this.toString();
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!b[i]) {
                path[u] = nums[i];
                b[i] = true;
                dfs(nums, u+1,k);
                b[i] = false;
                path[u] = 0;
            }

        }
    }
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : path) {
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}