package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class LicenseKeyFormatting {
    public static void main(String[] args) {
        Solution solution = new LicenseKeyFormatting().new Solution();
        solution.licenseKeyFormatting("5F3Z-2e-9-w-aa", 4);
        solution.licenseKeyFormatting("2-5g-3-J", 2);
    }

    /**
     * 密钥格式化
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String licenseKeyFormatting(String s, int k) {
            if (s.length() == 1 && !"-".equals(s)) {
                return s.toUpperCase();
            }
            String[] split = s.split("-");
            List<Character> list = new ArrayList<>();
            int sumLen = 0;
            for (int i = 0; i < split.length; i++) {
                sumLen += split[i].length();
                String s1 = split[i].toUpperCase();
                for (int j = 0; j < s1.length(); j++) {
                    list.add(s1.charAt(j));
                }
            }

            int first = sumLen % k;
            StringBuilder res = new StringBuilder();

            int o = 0;
            int q = 0;
            while (sumLen > 0) {
                if (first > 0) {
                    res.append(list.get(o));
                    o++;
                    sumLen--;
                    if (--first == 0) {
                        res.append("-");
                    }
                } else {
                    res.append(list.get(o));
                    o++;
                    sumLen--;
                    if (++q == k && sumLen != 0) {
                        res.append("-");
                        q = 0;
                    }
                }
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
