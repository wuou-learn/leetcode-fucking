package com.solve.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

class UglyNumberIi {
    public static void main(String[] args) {
        Demo test1 = new Demo("test1", 1);
        Demo test2 = new Demo("test2", 2);
        Demo test3 = new Demo("test3", 3);
        List<Demo> list = new ArrayList<>();
        list.add(test3);
        list.add(test2);
        list.add(test1);
        List<Demo> collect =
                list.stream()
                        .filter(demo -> Objects.nonNull(demo.getPriority()))
                        .sorted(Comparator.comparing(Demo::getPriority, Comparator.naturalOrder()))
                        .collect(Collectors.toList());
        Queue<Demo> pq = new ArrayDeque<>(collect);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }

    /**
     * 丑数 II
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] nums = new int[]{2,3,5};
        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            Queue<Long> pq = new PriorityQueue<>();
            set.add(1L);
            pq.add(1L);
            for (int i = 1; i <= n; i++) {
                long x = pq.poll();
                if (i == n) {
                    return (int)x;
                }
                for (int num : nums) {
                    long t = num * x;
                    if (!set.contains(t)) {
                        set.add(t);
                        pq.add(t);
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    static class Demo {
        private String name;
        private Integer priority;

        public Demo(String name, Integer priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getPriority() {
            return priority;
        }

        public void setPriority(Integer priority) {
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Demo{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }


    }
}
