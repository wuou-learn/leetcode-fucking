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
//        String str = "123";
//        String substring1 = str.substring(0, 1);
//        String substring2 = str.substring(0, 2);
//        String substring3 = str.substring(0, 3);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    String res = "";
    int [] nums;
    boolean [] path;
    int idx = 0;
    public String getPermutation(int n, int k) {
        nums = new int[n];
        path = new boolean[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }


        dfs(0,k,n,"");

        return res;
    }
    public void dfs(int u, int k, int n, String str) {
        if (!res.isEmpty()) {
            return;
        }
        if (u > n) {
            return;
        }
        if (n == u && ++idx == k) {
            res = str;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path[i]) {
                str += nums[i];
                path[i] = true;
                dfs(u+1, k, n, str);
                str = str.substring(0, str.length() - 1);
                path[i] = false;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}