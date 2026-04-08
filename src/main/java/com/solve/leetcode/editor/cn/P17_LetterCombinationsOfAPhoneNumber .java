//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2767 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 电话号码的字母组合
 *
 * @author wuou
 * @date 2024-03-04 21:03:41
 */
class P17_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    //力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public List<String> letterCombinations(String digits) {
            String [] d = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            Deque<String> deque = new ArrayDeque<>();
            deque.offer("");
            for (char c : digits.toCharArray()) {
                String s = d[c - '0'];
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    String poll = deque.poll();
                    for (char sc : s.toCharArray()) {
                        deque.offer(poll + sc);
                    }
                }
            }

            return new ArrayList<>(deque);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}