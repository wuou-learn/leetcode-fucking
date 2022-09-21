package com.solve.leetcode.editor.cn;

class UglyNumber {
    public static void main(String[] args) {
        Solution solution = new UglyNumber().new Solution();
        solution.isUgly(0);
        System.out.println();
    }

    /**
     * 丑数
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isUgly(int n) {
            if (n == 0) {
                return false;
            }
            while (n%2 == 0){
                n /= 2;
            }
            if (n == 1) {
                return true;
            }
            while (n%3 == 0){
                n /= 3;
            }
            if (n == 1) {
                return true;
            }
            while (n%5 == 0){
                n /= 5;
            }
            if (n == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
