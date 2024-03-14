//给你一个正整数 n ，请你返回 n 的 惩罚数 。 
//
// n 的 惩罚数 定义为所有满足以下条件 i 的数的平方和： 
//
// 
// 1 <= i <= n 
// i * i 的十进制表示的字符串可以分割成若干连续子字符串，且这些子字符串对应的整数值之和等于 i 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：182
//解释：总共有 3 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//因此，10 的惩罚数为 1 + 81 + 100 = 182
// 
//
// 示例 2： 
//
// 
//输入：n = 37
//输出：1478
//解释：总共有 4 个整数 i 满足要求：
//- 1 ，因为 1 * 1 = 1
//- 9 ，因为 9 * 9 = 81 ，且 81 可以分割成 8 + 1 。
//- 10 ，因为 10 * 10 = 100 ，且 100 可以分割成 10 + 0 。
//- 36 ，因为 36 * 36 = 1296 ，且 1296 可以分割成 1 + 29 + 6 。
//因此，37 的惩罚数为 1 + 81 + 100 + 1296 = 1478
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// Related Topics 数学 回溯 👍 126 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 求一个整数的惩罚数
 * @author wuou
 * @date 2024-03-14 16:41:55
 */
class P2698_FindThePunishmentNumberOfAnInteger{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2698_FindThePunishmentNumberOfAnInteger().new Solution();
        solution.punishmentNumber(10);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> path = new ArrayList<>();
    Set<Integer> ans = new HashSet<>();
    public int punishmentNumber(int n) {
        for (int i = 1; i <= n; i++) {
            dfs(n,String.valueOf(i*i),0);
        }
        int res = 0;
        for (Integer i : ans) {
            res += i;
        }
        return res;
    }
    public void dfs(int n, String num, int u) {
        if (u == num.length()) {
            double sum = 0;
            for (Integer i : path) {
                sum+=i;
            }
            int ii = Integer.parseInt(num);
            double sqrt = Math.sqrt(ii);
            if (sum - sqrt != 0) {
                return;
            }
            ans.add(ii);
        }
        for (int i = u; i < num.length(); i++) {
            String sub = num.substring(u, i + 1);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                continue;
            }
            int j = Integer.parseInt(sub);
            if (j > n) {
                continue;
            }
            path.add(j);
            dfs(n, num, i+1);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}