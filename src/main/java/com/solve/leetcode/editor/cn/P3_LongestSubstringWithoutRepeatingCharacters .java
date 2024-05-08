//给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 10131 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * @author wuou
 * @date 2024-05-08 20:28:34
 */
class P3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("pwwkew");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] array = s.toCharArray();
        int res = 0;
        for (int i = 0, j = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
            while (map.getOrDefault(array[i],0) > 1) {
                char end = array[j++];
                map.put(end, map.get(end)-1);
            }
            res = Math.max(res, i-j+1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}