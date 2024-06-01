//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。 
//
// s 中的 串联子串 是指一个包含 words 中所有字符串以任意顺序排列连接起来的子串。 
//
// 
// 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，
//"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。 
// 
//
// 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
//子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
//子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
//输出顺序无关紧要。返回 [9,0] 也是可以的。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
//s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
//所以我们返回一个空数组。
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
//子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
//子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
//子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 1112 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 * @author wuou
 * @date 2024-05-30 21:11:15
 */
class P30_SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P30_SubstringWithConcatenationOfAllWords().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> wordsCnt = new HashMap<>(m);
        for (int i = 0; i < words.length; i++) {
            wordsCnt.put(words[i], wordsCnt.getOrDefault(words[i], 0)+1);
        }

        for (int i = 0; i < w; i ++) {
            Map<String, Integer> wd = new HashMap<>(m);
            int cnt = 0;
            for (int j = i; j + w <= n; j+=w) {
                // 窗口满了
                if (j >= m * w) {
                    // 删除第一个窗口第一个元素
                    String word = s.substring(j-m*w, j+w-m*w);
                    wd.put(word, wd.getOrDefault(word, 0)-1);
                    // 如果我们删除了一个有效的单词 cnt--
                    // wordsCnt.get(word) != null 表示word是有效的单词组中的一组
                    // wd.get(word) < wordsCnt.get(word) 表示滑动窗口中删除word后，删除了一个有效的单词
                    if (wordsCnt.get(word) != null && wd.get(word) < wordsCnt.get(word)) {
                        cnt--;
                    }
                }
                // 最右边的元素 进入滑动窗口
                String word = s.substring(j, j+w);
                wd.put(word, wd.getOrDefault(word, 0)+1);
                // 如果增加一个有效单词
                if (wordsCnt.get(word) != null && wd.get(word) <= wordsCnt.get(word)) {
                    cnt++;
                }
                if (cnt == m) {
                    // 索引-单词的总长度
                    res.add(j-(m-1)*w);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}