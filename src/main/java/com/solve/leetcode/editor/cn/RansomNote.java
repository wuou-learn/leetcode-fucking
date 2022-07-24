//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics哈希表 | 字符串 | 计数 
//
// 👍 402, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        solution.canConstruct("a", "b");
    }

    /**
     * 赎金信
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int [] array = new int[26];
            for (int i =0; i<ransomNote.length(); i++) {
                array[ransomNote.charAt(i) - 'a']++;
            }
            for (int i =0; i<magazine.length(); i++) {
                array[magazine.charAt(i) - 'a']--;
            }
            for (int i = 0; i<array.length; i++) {
                if (array[i] > 0) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}