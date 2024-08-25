//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ： 
//
// "1" -> 'A' "2" -> 'B' ... "25" -> 'Y' "26" -> 'Z' 
//
// 然而，在 解码 已编码的消息时，你意识到有许多不同的方式来解码，因为有些编码被包含在其它编码当中（"2" 和 "5" 与 "25"）。 
//
// 例如，"11106" 可以映射为： 
//
// 
// "AAJF" ，将消息分组为 (1, 1, 10, 6) 
// "KJF" ，将消息分组为 (11, 10, 6) 
// 消息不能分组为 (1, 11, 06) ，因为 "06" 不是一个合法编码（只有 "6" 是合法的）。 
// 
//
// 注意，可能存在无法解码的字符串。 
//
// 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。如果没有合法的方式解码整个字符串，返回 0。 
//
// 题目数据保证答案肯定是一个 32 位 的整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2： 
//
// 
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
//
// 示例 3： 
//
// 
//输入：s = "06"
//输出：0
//解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含数字，并且可能包含前导零。 
// 
//
// Related Topics 字符串 动态规划 👍 1525 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 解码方法
 * @author wuou
 * @date 2024-07-15 19:09:55
 */
class P91_DecodeWays{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P91_DecodeWays().new Solution();
        solution.numDecodings("1226");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        /**
         * dp
         * eg: 1226 = ABZ/ABBF
         * 1 : 1 = 1
         * 12 : 2 = AB / L
         * 122 : 3 = ABB / LB
         * 1226 : 5 = ABBF / ABZ / LBF / AVF / LZ ;
         * 12262 : 5 = ABBFB / ABZB / LBFB / AVFB / LZB;
         *
         * 集合：前i个能解码回去的字符串
         * 属性：个数
         *
         * f(i)
         * 状态计算：最后一个数字｜最后一个字符对应两个数字
         *         f(i-1)    ｜  f(i-2)
         */
        int n = s.length();
        int [] f = new int[n+1];
        f[0] = 1;
        for (int i = 1; i <= n; i ++) {
            char c = s.charAt(i-1);
            if (c >= '1' && c <= '9') f[i] += f[i-1];
            if (i > 1) {
                int t = ((s.charAt(i-2) - '0') * 10) + s.charAt(i-1) - '0';
                if (t >= 10 && t <= 26) {
                    f[i] += f[i-2];
                }
            }
        }
        return f[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}