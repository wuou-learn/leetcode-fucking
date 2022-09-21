package com.solve.leetcode.editor.cn;

class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        Solution solution = new ExcelSheetColumnTitle().new Solution();
        solution.convertToTitle(28);
    }

    /**
     * Excel表列名称
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToTitle(int cn) {
            StringBuilder sb = new StringBuilder();
            while (cn > 0) {
                cn--;
                sb.append((char) (cn % 26 + 'A'));
                cn /= 26;
            }
            sb.reverse();
            return sb.toString();
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
