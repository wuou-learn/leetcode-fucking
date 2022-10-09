package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

class FractionToRecurringDecimal{
  public static void main(String[] args) {
       Solution solution = new FractionToRecurringDecimal().new Solution();
      solution.fractionToDecimal(4, 333);
  }
  /**
   * 分数到小数
   */
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long x = (long) numerator;
        long y = (long) denominator;
        StringBuilder res = new StringBuilder();
        if (x * y < 0) {
            res.append("-");
        }
        x = Math.abs(x);
        y = Math.abs(y);
        if (x % y == 0) {
            return res.append(x/y).toString();
        }
        // 商
        res.append(x/y);
        res.append(".");
        // 余数
        x = x % y;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(x, res.length());
        while (x != 0) {
            x *= 10;
            res.append(x/y);
            x %= y;
            if (map.containsKey(x)) {
                res.insert(map.get(x), "(");
                res.append(")");
                break;
            } else {
                map.put(x, res.length());
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
