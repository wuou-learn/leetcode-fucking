//给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。 
//
// 重复出现（不同位置）的子串也要统计它们出现的次数。 
// 
//
// 示例 1： 
//
// 
//输入：s = "00110011"
//输出：6
//解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
//注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
//另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。 
//
// 示例 2： 
//
// 
//输入：s = "10101"
//输出：4
//解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 '0' 或 '1' 
// 
// Related Topics双指针 | 字符串 
//
// 👍 469, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        Solution solution = new CountBinarySubstrings().new Solution();
        solution.countBinarySubstrings("0011");
    }

    /**
     * 计数二进制子串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            List<Integer> list = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int count = 0;
                char c = s.charAt(i);
                while (i < s.length() && c == s.charAt(i)) {
                    count++;
                    i++;
                }
                list.add(count);
            }
            int res = 0;
            for (int j = 1; j < list.size(); j++) {
                res+= Math.min(list.get(j), list.get(j-1));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}