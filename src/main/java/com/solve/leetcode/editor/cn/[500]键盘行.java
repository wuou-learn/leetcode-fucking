package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
        solution.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
    }

    /**
     * 键盘行
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        public String[] findWords(String[] words) {
            init();
            List<String> list = new ArrayList<>();
            for (String str : words) {
                int line = 0;
                int line0 = 0;
                String s = str.toLowerCase();
                for (int i = 0; i < s.length(); i++) {
                    line0 = hashMap.get(s.charAt(i));
                    if (i == 0) {
                        line = line0;
                    }else if (line != line0) {
                        break;
                    }
                }
                if (line == line0 && line0 != 0) {
                    list.add(str);
                }
            }
            String[] res = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
        public void init() {
            String line = "qwertyuiop";
            for (int i = 0; i < line.length(); i++) {
                hashMap.put(line.charAt(i), 1);
            }
            line = "asdfghjkl";
            for (int i = 0; i < line.length(); i++) {
                hashMap.put(line.charAt(i), 2);
            }
            line = "zxcvbnm";
            for (int i = 0; i < line.length(); i++) {
                hashMap.put(line.charAt(i), 3);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
