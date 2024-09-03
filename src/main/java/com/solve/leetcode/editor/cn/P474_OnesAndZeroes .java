//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
// 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
//
// Related Topics 数组 字符串 动态规划 👍 1165 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 一和零
 * @author wuou
 * @date 2024-09-02 20:56:41
 */
class P474_OnesAndZeroes{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P474_OnesAndZeroes().new Solution();
        solution.findMaxForm(new String[]{"10","0","1"}, 1, 1);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int res = 0;
    public int findMaxForm(String[] strs, int m, int n) {
        dfs(0,strs,m,n,0);
        return res;
    }

    public void dfs(int u, String[] strs, int a0, int a1, int temp) {
        if (u >= strs.length) {
            res = Math.max(temp, res);
            return;
        }
        char[] s = strs[u].toCharArray();
        int t0 = 0;
        int t1 = 0;
        for (char c : s) {
            if (c - '0' == 0) {
                t0++;
            } else {
                t1++;
            }
        }
        // 选s
        if (t0 <= a0 && t1 <= a1) {
            dfs(u + 1, strs, a0 - t0, a1 - t1, temp + Integer.parseInt(strs[u], 2));
        }
        // 不选s
        dfs(u + 1, strs, a0, a1, temp);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}