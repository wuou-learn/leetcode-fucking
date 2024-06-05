//「外观数列」是一个数位字符串序列，由递归公式定义： 
//
// 
// countAndSay(1) = "1" 
// countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。 
// 
//
// 
//
// 
// 
//
// 行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符
//串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替
//换。因此压缩后字符串变为 "23321511"。 
//
// 给定一个整数 n ，返回 外观数列 的第 n 个元素。 
//
// 示例 1： 
//
// 
// 输入：n = 4 
// 
//
// 输出："1211" 
//
// 解释： 
//
// countAndSay(1) = "1" 
//
// countAndSay(2) = "1" 的行程长度编码 = "11" 
//
// countAndSay(3) = "11" 的行程长度编码 = "21" 
//
// countAndSay(4) = "21" 的行程长度编码 = "1211" 
//
// 示例 2： 
//
// 
// 输入：n = 1 
// 
//
// 输出："1" 
//
// 解释： 
//
// 这是基本情况。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 30 
// 
//
// 
//进阶：你能迭代解决该问题吗？
//
// Related Topics 字符串 👍 1085 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 外观数列
 * @author wuou
 * @date 2024-06-05 20:14:29
 */
class P38_CountAndSay{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P38_CountAndSay().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder t = new StringBuilder();
            for (int j = 0; j < s.length();) {
                int k = j + 1;
                while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                    k++;
                }
                t.append(k - j);
                t.append(s.charAt(j));
                j = k;
            }
            s = t.toString();
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}