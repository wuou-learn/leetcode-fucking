package com.solve.leetcode.editor.cn;

import java.util.*;

class BrickWall {
    public static void main(String[] args) {
        Solution solution = new BrickWall().new Solution();
        List<List<Integer>> wall = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(1);
        list5.add(2);
        List<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(3);
        list6.add(1);
        list6.add(1);
        wall.add(list1);
        wall.add(list2);
        wall.add(list3);
        wall.add(list4);
        wall.add(list5);
        wall.add(list6);
        solution.leastBricks(wall);
    }

    /**
     * 砖墙
     */
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            // 高度
            int h = wall.size();
            // 缝隙坐标-出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            // 取缝隙出现位置最多的地方插入，传过砖块越少的地方 = h - 最多缝隙的地方
            for (int i = 0, n = 0; i < h; i++, n=0) {
                for (int num : wall.get(i)) {
                    n += num;
                    map.put(n, map.getOrDefault(n, 0)+1);
                }
                map.remove(n);
            }
            int max = 0;
            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                max = Math.max(entry.getValue(),max);
            }
            return h - max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
