package com.solve.leetcode.editor.cn;

class RotateList {
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();

        ListNode node3= new ListNode(2,null);
        ListNode node2 = new ListNode(1,node3);
        ListNode node1 = new ListNode(0,node2);
        solution.rotateRight(node1,2);
    }
    /**
     * 旋转链表
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
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int size = 1;
            ListNode dummy = head;
            while(dummy.next != null) {
                size ++;
                dummy = dummy.next;
            }

            int count = size-k % size;
            if (count == 0) {
                return head;
            }

            dummy.next = head;
            while (count -- > 0) {
                dummy = dummy.next;
            }
            ListNode res = dummy.next;
            dummy.next = null;
            return res;
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
