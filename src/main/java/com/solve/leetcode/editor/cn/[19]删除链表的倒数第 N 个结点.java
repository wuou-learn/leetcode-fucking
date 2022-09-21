package com.solve.leetcode.editor.cn;

class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, node2);
        solution.removeNthFromEnd(node1,1);
    }
    /**
     * 删除链表的倒数第 N 个结点
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            int size = 0;
            ListNode prev = new ListNode(-1);
            prev.next = head;
            ListNode cur = head;
            while (cur != null) {
                size ++;
                cur = cur.next;
            }
            ListNode node = prev;
            for (int i = 1; i < size - n + 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            return prev.next;

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
