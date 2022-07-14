//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 
//
// 示例 1: 
//
// 
//输入: "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串
// 
//
// 示例 2: 
//
// 
//输入: "race a car"
//输出: false
//解释："raceacar" 不是回文串
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
// Related Topics双指针 | 字符串 
//
// 👍 548, 👎 0 
//
//
//
//


package com.solve.leetcode.editor.cn;

public class ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }

    /**
     * 125 验证回文串
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            String lowerCase = s.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i<lowerCase.length(); i++) {
                if (Character.isLetterOrDigit(lowerCase.charAt(i))) {
                    sb.append(lowerCase.charAt(i));
                }
            }
            int left = 0; int right = sb.length()-1;
            while (left < right) {
                if (sb.charAt(left) == sb.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}