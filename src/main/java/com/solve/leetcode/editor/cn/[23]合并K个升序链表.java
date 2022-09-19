package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
    }
    /**
     * 合并K个升序链表
     */
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ArrayList<Integer> list = new ArrayList<>();
            for (ListNode node : lists) {
                while(node != null){
                    list.add(node.val);
                    node = node.next;
                }
            }
            List<Integer> collect = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            ListNode res = new ListNode(-1);
            ListNode dummy = res;
            for (Integer val : collect) {
                dummy.next = new ListNode(val);
                dummy = dummy.next;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
