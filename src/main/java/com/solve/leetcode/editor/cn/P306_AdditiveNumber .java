//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
//
// Related Topics 字符串 回溯 👍 438 👎 0


package com.solve.leetcode.editor.cn;


import java.math.BigDecimal;

/**
 * 累加数
 * @author wuou
 * @date 2024-03-13 19:22:24
 */
class P306_AdditiveNumber{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P306_AdditiveNumber().new Solution();
        solution.isAdditiveNumber("211738");
//        solution.isAdditiveNumber("112358");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
//import java.math.BigDecimal;
class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j + 1 < num.length(); j++) {
                int a = 0, b = i+1, c = j+1;
                while (true) {
                    String x = num.substring(a, b);
                    String y = num.substring(b,c);
                    if (x.charAt(0) == '0' && x.length() > 1) {
                        break;
                    }
                    if (y.charAt(0) == '0' && y.length() > 1) {
                        break;
                    }
                    BigDecimal xx = new BigDecimal(x);
                    BigDecimal yy = new BigDecimal(y);

                    BigDecimal zz = xx.add(yy);
                    int zzLen = zz.toString().length();
                    if (c + zzLen > num.length()) {
                        break;
                    }
                    BigDecimal decimal = new BigDecimal(num.substring(c, c + zzLen));
                    if (decimal.compareTo(zz) != 0) {
                        break;
                    }
                    a = b;
                    b = c;
                    c += zzLen;
                    if (c == num.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}