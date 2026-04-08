//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1636 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 * @author wuou
 * @date 2025-03-27 14:04:48
 */
class P438_FindAllAnagramsInAString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P438_FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        int[] windows = new int[26];

        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int l = 0, r = 0; r < s.length(); r++) {
            windows[chars[r] - 'a']++;

            if (r - l + 1 > p.length()) {
                windows[chars[l] - 'a']--;
                l++;
            }

            if (Arrays.equals(count, windows)) {
                res.add(l);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}