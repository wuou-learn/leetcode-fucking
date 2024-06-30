//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1209 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Arrays;

/**
 * 二进制求和
 * @author wuou
 * @date 2024-06-30 19:28:18
 */
class P67_AddBinary{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P67_AddBinary().new Solution();
        solution.addBinary("11", "1");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder res = new StringBuilder();
        for (int i = 0, t = 0; i < a.length() || i < b.length() || t != 0; i++) {
            if (i < a.length()) t += a.charAt(i) - '0';
            if (i < b.length()) t += b.charAt(i) - '0';
            res.append(t % 2);
            t /= 2;
        }
        return res.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}