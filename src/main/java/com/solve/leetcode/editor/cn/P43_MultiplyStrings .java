//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1343 👎 0


package com.solve.leetcode.editor.cn;

import java.math.BigDecimal;

/**
 * 字符串相乘
 * @author wuou
 * @date 2024-06-13 19:39:11
 */
class P43_MultiplyStrings{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P43_MultiplyStrings().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}