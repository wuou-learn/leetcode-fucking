//给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "eleetminicoworoep"
//输出：13
//解释：最长子字符串是 "leetminicowor" ，它包含 e，i，o 各 2 个，以及 0 个 a，u 。
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcodeisgreat"
//输出：5
//解释：最长子字符串是 "leetc" ，其中包含 2 个 e 。
// 
//
// 示例 3： 
//
// 
//输入：s = "bcbcbc"
//输出：6
//解释：这个示例中，字符串 "bcbcbc" 本身就是最长的，因为所有的元音 a，e，i，o，u 都出现了 0 次。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 x 10^5 
// s 只包含小写英文字母。 
// 
//
// Related Topics 位运算 哈希表 字符串 前缀和 👍 511 👎 0


package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * 每个元音包含偶数次的最长子字符串
 * @author wuou
 * @date 2025-09-08 14:56:25
 */
class P1371_FindTheLongestSubstringContainingVowelsInEvenCounts{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1371_FindTheLongestSubstringContainingVowelsInEvenCounts().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheLongestSubstring(String s) {
        // (sum[j] - sum[i]) % 2 == 0;
        // sum[i] % 2 == sum[j] % 2
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') state ^= 1 << 0;
            if (c == 'e') state ^= 1 << 1;
            if (c == 'i') state ^= 1 << 2;
            if (c == 'o') state ^= 1 << 3;
            if (c == 'u') state ^= 1 << 4;

            if (map.containsKey(state)) {
                ans = Math.max(ans, i - map.get(state));
            } else {
                map.put(state, i);
            }
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}