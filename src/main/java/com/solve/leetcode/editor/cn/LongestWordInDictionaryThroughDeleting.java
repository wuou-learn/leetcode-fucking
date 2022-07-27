//给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
// 
//
// 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics数组 | 双指针 | 字符串 | 排序 
//
// 👍 310, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

import java.util.*;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting().new Solution();
        String [] str = new String []{"apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf"};
        solution.findLongestWord("aewfafwafjlwajflwajflwafj", Arrays.asList(str));
    }

    /**
     * 通过删除字母匹配到字典里最长单词
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            // 匹配到的多少个字符 / 字符串
            TreeMap<Integer, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());
            for (String str : dictionary) {
                int i = 0;
                int j = 0;
                int index = 0;
                while (i < str.length() && j < s.length()) {
                    if (str.charAt(i) == s.charAt(j)) {
                        index++;
                        i++;
                    }
                    j++;
                }
                if (index > 0 && index == str.length()) {
                    List<String> list = treeMap.get(index);
                    if (list != null) {
                        list.add(str);
                    } else {
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(str);
                        treeMap.put(index,arrayList);
                    }
                }
            }

            if (treeMap.size() == 0) {
                return "";
            }

            String res = "";
            int maxIndex = 0;
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, List<String>> entry : treeMap.entrySet()) {
                List<String> result = entry.getValue();
                result.sort((a, b) -> {
                    if (a.length() != b.length()) return b.length() - a.length();
                    return a.compareTo(b);
                });

                for (String str : result) {
                    int sum = 0;
                    for (int i =0; i<str.length(); i++) {
                        sum+=str.charAt(i);
                    }
                    if (entry.getKey() > maxIndex && sum < min) {
                        res = str;
                        maxIndex = entry.getKey();
                        min = sum;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}