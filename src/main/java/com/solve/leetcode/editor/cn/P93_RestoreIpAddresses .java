//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1400 👎 0


package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址
 * @author wuou
 * @date 2024-03-13 21:31:02
 */
class P93_RestoreIpAddresses{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P93_RestoreIpAddresses().new Solution();
        solution.restoreIpAddresses("25525511135");
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> path = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0);
        return ans;
    }
    public void dfs(String s, int u) {
        if (path.size() == 4 && u >= s.length()) {
            ans.add(String.join(".", path));
            return;
        }
        for (int i = u; i < s.length(); i++) {
            String sub = s.substring(u, i+1);
            if (sub.length() > 1 && sub.charAt(0) == '0') {
                continue;
            }
            if (sub.length() > 3 || Long.parseLong(sub) > 255) {
                continue;
            }
            path.add(sub);
            dfs(s, i+1);
            path.remove(path.size() - 1);
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}