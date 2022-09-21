package com.solve.leetcode.editor.cn;

class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution solution = new DeleteNodeInALinkedList().new Solution();

    }
    /**
     * 删除链表中的节点
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
