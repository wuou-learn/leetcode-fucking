//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 579 👎 0


package com.solve.leetcode.editor.cn;

/**
 * 表现良好的最长时间段
 * @author wuou
 * @date 2025-09-04 11:17:32
 */
class P1124_LongestWellPerformingInterval{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1124_LongestWellPerformingInterval().new Solution();
        solution.longestWPI(new int[]{9,9,6,0,6,6,9});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestWPI(int[] hours) {
        // [9,9,6,0,6,6,9]
        // [1,1,-1,-1,-1,-1,1]
        // [0,1,2,1,0,-1,-2,-1]
        int [] prefix = new int[hours.length + 1];
        for (int i = 0; i < hours.length; i++) {
            int num = hours[i] > 8 ? 1 : -1;
            prefix[i + 1] = prefix[i] + num;
        }
        int ans = 0;
        for (int i = 0; i < prefix.length; i++) {
            for (int j = i + 1; j < prefix.length; j++) {
                int k = prefix[j] - prefix[i];
                if (k > 0) {
                    ans = Math.max(j - i, ans);
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}