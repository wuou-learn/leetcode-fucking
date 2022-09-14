package com.solve.leetcode.editor.cn;

class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
    }
    /**
     * 两两交换链表中的节点
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
        public ListNode swapPairs(ListNode head) {

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            for (ListNode p = dummy; p.next != null && p.next.next != null; ) {
                ListNode a = p.next;
                ListNode b = a.next;
                p.next = b;
                a.next = b.next;
                b.next = a;
                p = a;
            }
            return dummy.next;
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
