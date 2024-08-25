//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2932 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * @author wuou
 * @date 2024-07-10 22:02:55
 */
class P76_MinimumWindowSubstring{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P76_MinimumWindowSubstring().new Solution();
        solution.minWindow("ADOBECODEBANC", "ABC");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        Map<Character, Integer> path = new HashMap<>();
        int cnt = 0;
        String res = "";
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            path.put(c, path.getOrDefault(c, 0) + 1);
            if (map.containsKey(c) && map.get(c) >= path.get(c)) {
                cnt++;
            }
            while (i <= j && (!map.containsKey(s.charAt(i)) || path.get(s.charAt(i)) > map.get(s.charAt(i)))) {
                i++;
            }
            if (cnt == t.length()) {
                String str = s.substring(i, j+1);
                if (res.isEmpty()) {
                    res = str;
                    continue;
                }
                res = str.length() < res.length() ? str : res;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}