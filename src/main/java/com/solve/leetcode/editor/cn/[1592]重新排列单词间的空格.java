package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class RearrangeSpacesBetweenWords {
    public static void main(String[] args) {
        Solution solution = new RearrangeSpacesBetweenWords().new Solution();
        solution.reorderSpaces("a b   c d");
        Long a = 156007L;
        System.out.println(a.hashCode());
    }

    /**
     * 重新排列单词间的空格
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reorderSpaces(String text) {
            String[] spaces = text.split("");

            int space = 0;
            for (int i = 0; i < spaces.length; i++) {
                if (Character.isSpaceChar(spaces[i].charAt(0))) {
                    space++;
                }
            }
            List<String> list = new ArrayList<>();
            String[] words = text.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (!"".equals(words[i]) && !Character.isSpaceChar(words[i].charAt(0))) {
                    list.add(words[i]);
                }
            }

            int num = list.size() == 1 ? space : space / (list.size()-1);
            StringBuilder res = new StringBuilder();
            for (String str : list) {
                res.append(str);
                if (space <= num) {
                    appendSpace(res, space);
                    space -= space;
                } else {
                    appendSpace(res,num);
                    space -= num;
                }
            }
            if (space != 0) {
                appendSpace(res, space);
            }
            return res.toString();
        }

        public StringBuilder appendSpace(StringBuilder space, int num) {
            for (int i = 0; i < num; i++) {
                space.append(" ");
            }
            return space;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
