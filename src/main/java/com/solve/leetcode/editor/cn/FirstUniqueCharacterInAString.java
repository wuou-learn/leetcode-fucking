//给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode"
//输出: 0
// 
//
// 示例 2: 
//
// 
//输入: s = "loveleetcode"
//输出: 2
// 
//
// 示例 3: 
//
// 
//输入: s = "aabb"
//输出: -1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写字母 
// 
// Related Topics队列 | 哈希表 | 字符串 | 计数 
//
// 👍 576, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.*;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
        solution.firstUniqChar("loveleetcode");
    }

    /**
     * 字符串中的第一个唯一字符
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            Map<Character,Integer> map = new HashMap<>(s.length());
            for (int i = 0; i<s.length(); i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            }
            for (int i = 0; i<s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}