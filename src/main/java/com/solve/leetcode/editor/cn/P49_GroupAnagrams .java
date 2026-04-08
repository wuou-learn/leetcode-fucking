//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1913 👎 0


package com.solve.leetcode.editor.cn;

import java.util.*;

/**
 * 字母异位词分组
 * @author wuou
 * @date 2024-06-16 17:40:56
 */
class P49_GroupAnagrams{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P49_GroupAnagrams().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] hash = new int[26];
            for (char c : str.toCharArray()) {
                hash[c - 'a'] ++;
            }
            StringBuilder s = new StringBuilder();
            for (int i : hash) {
                s.append(i).append("-");
            }
            String key = s.toString();
            if (map.containsKey(key)) {
                List<String> values = map.get(key);
                values.add(str);
            } else {
                List<String> values = new ArrayList<>();
                values.add(str);
                map.putIfAbsent(s.toString(), values);
            }
        }
        return new ArrayList<>(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}