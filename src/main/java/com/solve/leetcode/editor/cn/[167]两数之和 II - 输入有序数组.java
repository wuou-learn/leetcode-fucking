package com.solve.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
    }

    /**
     * 两数之和 II - 输入有序数组
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            // key value  value index
            Map<Integer,Integer> map = new HashMap<Integer,Integer>();
            int [] res = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                if(map.containsKey(target - numbers[i])){
                    res[0] = map.get(target - numbers[i])+1;
                    res[1] = i+1;
                    return res;
                }
                map.put(numbers[i],i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
