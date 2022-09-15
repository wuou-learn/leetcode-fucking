package com.solve.leetcode.editor.cn;

class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
    }
    /**
     * 反转链表
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
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode a = head, b = a.next, c;
            while (b != null) {
                c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            head.next = null;
            return a;
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
