//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1404 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 加一
 * @author wuou
 * @date 2024-06-30 19:10:16
 */
class P66_PlusOne{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P66_PlusOne().new Solution();
        solution.plusOne(new int[]{1,2,3});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> stack = new Stack<>();
        addOne(digits, stack);
        int [] res = new int[stack.size()];
        int idx = 0;
        while (!stack.isEmpty()) {
            res[idx] = stack.pop();
            idx++;
        }
        return res;
    }

    public void addOne(int[] digits, Stack<Integer> stack) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + 1;
            if (num > 9) {
                digits[i] = 0;
                stack.add(digits[i]);
                if (i == 0) {
                    stack.add(num / 10);
                }
            } else {
                digits[i] = num;
                stack.add(digits[i]);
                // 计算小于进位后 无需计算
                if (i > 0) {
                    for (int j = i - 1; j >= 0; j--) {
                        stack.add(digits[j]);
                    }
                }
                return;
            }
        }
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}