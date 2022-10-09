package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class RemoveLetterToEqualizeFrequency {
    public static void main(String[] args) {
        Solution solution = new RemoveLetterToEqualizeFrequency().new Solution();
        solution.equalFrequency("ddaccb");
    }

    /**
     * 删除字符使频率相同
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equalFrequency(String word) {
            char[] array = word.toCharArray();
            int[] arr = new int[26];
            for (char c : array) {
                arr[c - 'a']++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    arr[i]--;
                    Set<Integer> set = new HashSet<>();
                    for (int j = 0; j < arr.length; j++) {
                        if (arr[j] != 0) {
                            set.add(arr[j]);
                        }
                    }
                    if (set.size() == 1) {
                        return true;
                    }
                    arr[i]++;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
