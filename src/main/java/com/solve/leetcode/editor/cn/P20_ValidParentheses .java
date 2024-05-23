//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4396 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * @author wuou
 * @date 2024-03-24 22:02:20
 */
class P20_ValidParentheses{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P20_ValidParentheses().new Solution();
        solution.isValid("([)]");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // 判断当前元素 顶上元素是否一对
            char c = charArray[i];
            Character b = map.get(c);
            if (!stack.isEmpty() && b != null && b.equals(stack.peek())) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}