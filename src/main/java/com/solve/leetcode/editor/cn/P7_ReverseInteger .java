//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3988 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 整数反转
 * @author wuou
 * @date 2024-05-13 20:05:10
 */
class P7_ReverseInteger{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P7_ReverseInteger().new Solution();
        solution.reverse(-123);

    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /*// 字符串反转
    public int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder res = new StringBuilder();
        boolean f = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0 && s.charAt(i) == '-') {
                f = true;
                continue;
            }
            res.append(s.charAt(i));
        }
        long l = Long.parseLong(res.toString());
        int r = l > Integer.MAX_VALUE || l < Integer.MIN_VALUE ? 0 : Integer.parseInt(res.toString());
        return f ? -r : r;
    }*/

    public int reverse(int x) {
        int r = 0;
        // 秦九韶算法
        while (x != 0) {
            // 溢出情况考虑
            if (r > 0 && r > (Integer.MAX_VALUE - r % 10) / 10) {
                return 0;
            }
            if (r < 0 && r < (Integer.MIN_VALUE - r % 10) / 10) {
                return 0;
            }
            r = r * 10 + x % 10;
            x /= 10;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}