package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class CellsInARangeOnAnExcelSheet {
    public static void main(String[] args) {
        Solution solution = new CellsInARangeOnAnExcelSheet().new Solution();
        solution.cellsInRange("K1 Q7");
    }

    /**
     * Excel 表中某个范围内的单元格
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> cellsInRange(String s) {
            List<String> ans = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (char i = chars[0]; i <= chars[3]; ++i) {
                for (char j = chars[1]; j <= chars[4]; ++j) {
                    ans.add(String.valueOf(i) + j);
                }
            }
            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
