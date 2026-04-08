//「无零整数」是十进制表示中 不含任何 0 的正整数。 
//
// 给你一个整数 n，请你返回一个 由两个整数组成的列表 [a, b]，满足： 
//
// 
// a 和 b 都是无零整数 
// a + b = n 
// 
//
// 题目数据保证至少有一个有效的解决方案。 
//
// 如果存在多个有效解决方案，你可以返回其中任意一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：[1,1]
//解释：a = 1, b = 1。a + b = n 并且 a 和 b 的十进制表示形式都不包含任何 0。
// 
//
// 示例 2： 
//
// 
//输入：n = 11
//输出：[2,9]
// 
//
// 示例 3： 
//
// 
//输入：n = 10000
//输出：[1,9999]
// 
//
// 示例 4： 
//
// 
//输入：n = 69
//输出：[1,68]
// 
//
// 示例 5： 
//
// 
//输入：n = 1010
//输出：[11,999]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁴ 
// 
//
// Related Topics 数学 👍 47 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 将整数转换为两个无零整数的和
 * @author wuou
 * @date 2025-09-08 10:14:33
 */
class P1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1317_ConvertIntegerToTheSumOfTwoNoZeroIntegers().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a <= n; a++) {
            int b = n - a;
            if (isValid(a) && isValid(b)) {
                return new int[]{a,b};
            }
        }
        return null;
    }
    public boolean isValid(int n) {
        while (n != 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}