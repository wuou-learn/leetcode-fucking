//给你两个 正 整数 n 和 x 。 
//
// 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满
//足 n = n1ˣ + n2ˣ + ... + nkˣ 。 
//
// 由于答案可能非常大，请你将它对 10⁹ + 7 取余后返回。 
//
// 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2³ + 3³ + 5³ 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10, x = 2
//输出：1
//解释：我们可以将 n 表示为：n = 3² + 1² = 10 。
//这是唯一将 10 表达成不同整数 2 次方之和的方案。
// 
//
// 示例 2： 
//
// 输入：n = 4, x = 1
//输出：2
//解释：我们可以将 n 按以下方案表示：
//- n = 4¹ = 4 。
//- n = 3¹ + 1¹ = 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 300 
// 1 <= x <= 5 
// 
//
// Related Topics 动态规划 👍 19 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 将一个数字表示成幂的和的方案数
 * @author wuou
 * @date 2024-08-30 15:11:51
 */
class P2787_WaysToExpressAnIntegerAsSumOfPowers{
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P2787_WaysToExpressAnIntegerAsSumOfPowers().new Solution();
//        solution.numberOfWays(3, 1);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(3);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(1);
        list3.add(1);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWays(int n, int x) {
        int c = 1000000007;
        int[][] f = new int[n + 1][n + 1];
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] =(int) Math.pow(i, x);
        }
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j-a[i] >=0 && j-a[i] <= n) {
                    f[i][j] += f[i-1][j-a[i]];
                }
                f[i][j] = (f[i][j] + f[i-1][j]) % c;
                System.out.print("f["+i+"]["+j+"]"+"="+f[i][j] + " ");
            }
            System.out.println();
        }
        return f[n][n] % c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}