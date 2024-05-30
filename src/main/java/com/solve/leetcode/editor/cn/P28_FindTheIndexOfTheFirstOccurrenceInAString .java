//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
//如果 needle 不是 haystack 的一部分，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。
// 
//
// 示例 2： 
//
// 
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
//
// Related Topics 双指针 字符串 字符串匹配 👍 2228 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 找出字符串中第一个匹配项的下标
 * @author wuou
 * @date 2024-05-29 21:04:13
 */
class P28_FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P28_FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        solution.strStr("abbaba", "aba");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String s, String p) {
        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        int [] next = new int[m+1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j != 0 && p.charAt(i) != p.charAt(j+1)) {
                j = next[j];
            }
            if (p.charAt(i) == p.charAt(j+1)) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            while (j != 0 && s.charAt(i) != p.charAt(j+1)) {
                j = next[j];
            }
            if (s.charAt(i) == p.charAt(j+1)) {
                j++;
            }
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}