package com.solve.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    /**
     * 合并两个有序链表
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ArrayList<Integer> list = new ArrayList<>();
            while(list1 != null){
                list.add(list1.val);
                list1 = list1.next;
            }
            while(list2 != null){
                list.add(list2.val);
                list2 = list2.next;
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

    static class ListNode {
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
