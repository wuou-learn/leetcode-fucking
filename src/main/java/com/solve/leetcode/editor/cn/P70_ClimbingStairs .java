//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3472 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * @author wuou
 * @date 2024-03-19 19:56:16
 */
class P70_ClimbingStairs{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P70_ClimbingStairs().new Solution();
        solution.climbStairs(4);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /*int [] choice = new int[]{1,2};
    int res = 0;
    public int climbStairs(int n) {
        dfs(n,0);
        return res;
    }

    public void dfs(int n, int u) {
        if (n == u) {
            res ++;
            return;
        }
        for (int i : choice) {
            int i1 = u + i;
            if (i1 > n) {
                continue;
            }
            dfs(n,u+i);
        }
    }*/
    /*int [] m;
    public int climbStairs(int n) {
        m = new int[n + 1];
        Arrays.fill(m, -1);
        return dfs(n);
    }
    public int dfs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (m[n] != -1) {
            return m[n];
        }
        int count1 = dfs(n-1);
        int count2 = dfs(n-2);
        m[n] = count1 + count2;
        return m[n];
    }*/
    /*int [] m;
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        m = new int[n + 1];
        m[1] = 1;
        m[2] = 2;
        for (int i = 3; i <= n; i++) {
            m[i] = m[i-1] + m[i-2];
        }
        return m[n];
    }*/
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}