//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下： 
//
// 
//P   A   H   N
//A P L S I I G
//Y   I   R 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// 
//string convert(string s, int numRows); 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
// 
//
//示例 2：
//
// 
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I    N
//A   L S  I G
//Y A   H R
//P     I
// 
//
// 示例 3： 
//
// 
//输入：s = "A", numRows = 1
//输出："A"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由英文字母（小写和大写）、',' 和 '.' 组成 
// 1 <= numRows <= 1000 
// 
//
// Related Topics 字符串 👍 2308 👎 0


package com.solve.leetcode.editor.cn;

/**
 * Z 字形变换
 * @author wuou
 * @date 2024-05-10 20:59:16
 */
class P6_ZigzagConversion{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P6_ZigzagConversion().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // 每一行都是由2 * numRows - 2 的等差数列
        // 首尾是固定的2 * numRows - 2 等差数列
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows -1) {
                for (int j = i; j < s.length() ; j += 2 * numRows - 2) {
                    res.append(s.charAt(j));
                }
            } else {
                // 中间的则是相间隔的2*n-2的等差数列
                // 第一个开始的等差数列则与首尾相同
                // 第二个开始的等差数列则= 2*n-2-i
                for (int j = i, k = 2 * numRows - 2 - i; j < s.length() || k <s.length(); j += 2 * numRows - 2, k += 2 * numRows - 2) {
                    if (j < s.length()) res.append(s.charAt(j));
                    if (k < s.length()) res.append(s.charAt(k));
                }
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}