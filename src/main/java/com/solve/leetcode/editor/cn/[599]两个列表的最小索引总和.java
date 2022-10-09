package com.solve.leetcode.editor.cn;

import java.util.*;

class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution solution = new MinimumIndexSumOfTwoLists().new Solution();
    }

    /**
     * 两个列表的最小索引总和
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String,Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }

            int min = Integer.MAX_VALUE;
            TreeMap<Integer,List<String>> res = new TreeMap<>();
            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    int s = i + map.get(list2[i]);
                    if (s <= min) {
                        if (res.containsKey(s)) {
                            List<String> stringList = res.get(s);
                            stringList.add(list2[i]);
                        } else {
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(list2[i]);
                            res.put(s, arrayList);
                        }
                        min = s;
                    }
                }
            }
            List<String> resList = res.firstEntry().getValue();
            String [] strs = new String[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                strs[i] = resList.get(i);
            }
            return strs;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
