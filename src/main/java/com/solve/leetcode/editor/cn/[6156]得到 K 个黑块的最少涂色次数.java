package com.solve.leetcode.editor.cn;

import java.util.TreeMap;

class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        Solution solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks().new Solution();
        solution.minimumRecolors("WBBWWBBWBW",7);
    }

    /**
     * 得到 K 个黑块的最少涂色次数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            // 定义字符串长度
            int len = blocks.length();
            // 定义窗口做节点
            int left = 0;
            // 定义结果和次数
            int ret = k, cnt = 0;
            // 初始化窗口，先求前k个字符需要多少次
            for(int i = 0;i<k;i++){
                if(blocks.charAt(i) == 'W'){
                    cnt++;
                }
            }
            ret = Math.min(ret, cnt);
            // 向右一直滑动统计结果
            for(int right = k; right<len; right++){
                if(blocks.charAt(right) == 'W'){
                    cnt++;
                }
                if(blocks.charAt(left) == 'W'){
                    cnt--;
                }
                ret = Math.min(ret, cnt);
                left++;
            }
            return ret;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
