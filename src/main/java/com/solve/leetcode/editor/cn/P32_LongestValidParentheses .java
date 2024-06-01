//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 10⁴ 
// s[i] 为 '(' 或 ')' 
// 
//
// Related Topics 栈 字符串 动态规划 👍 2510 👎 0


package com.solve.leetcode.editor.cn;

import java.util.Stack;

/**
 * 最长有效括号
 * @author wuou
 * @date 2024-06-01 17:11:49
 */
class P32_LongestValidParentheses{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P32_LongestValidParentheses().new Solution();
        solution.longestValidParentheses("(()");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0, start = -1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    // 弹出栈顶元素进行配对
                    stack.pop();
                    if (!stack.isEmpty()) {
                        // 弹出之后 栈内元素不为空
                        // 当前idx-最后入栈的左括号的idx
                        res = Math.max(res, i-stack.peek());
                    } else {
                        // 弹出之后 栈内元素为空
                        res = Math.max(res, i-start);
                    }
                } else {
                    start = i;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}