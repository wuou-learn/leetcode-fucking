package com.solve.leetcode.editor.cn;

class ShortestPalindrome{
  public static void main(String[] args) {
       Solution solution = new ShortestPalindrome().new Solution();
      solution.shortestPalindrome("aacecaaa");
  }
  /**
   * 最短回文串
   */
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
      public String shortestPalindrome(String s) {
          String r = new StringBuilder(s).reverse().toString();
          String p = " " + s + "#" + r;
          char[] pp = p.toCharArray();
          int [] next = new int[pp.length];
          for (int i = 2, j = 0; i < pp.length; i++) {
              while (j!=0 && pp[i] != pp[j+1]) {
                  j = next[j];
              }
              if (pp[i] == pp[j+1]) {
                  j++;
              }
              next[i] = j;
          }
          int len = next[pp.length-1];
          return r.substring(0, r.length()-len) + s;
      }
}
//leetcode submit region end(Prohibit modification and deletion)

}
