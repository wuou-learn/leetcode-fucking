package com.solve.leetcode.editor.cn;

import java.math.BigInteger;

class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(9, null);

        ListNode a10 = new ListNode(9, null);
        ListNode a9 = new ListNode(9, a10);
        ListNode a8 = new ListNode(9, a9);
        ListNode a7 = new ListNode(9, a8);
        ListNode a6 = new ListNode(9, a7);
        ListNode a5 = new ListNode(9, a6);
        ListNode a4 = new ListNode(9, a5);
        ListNode a3 = new ListNode(9, a4);
        ListNode a2 = new ListNode(9, a3);
        ListNode a1 = new ListNode(1, a2);

        solution.addTwoNumbers(l1, a1);
    }
    /**
     * 两数相加
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return null;
            }
            StringBuilder i1 = new StringBuilder();
            while (l1 != null) {
                i1.append(l1.val);
                l1 = l1.next;
            }
            StringBuilder i2 = new StringBuilder();
            while (l2 != null) {
                i2.append(l2.val);
                l2 = l2.next;
            }
            BigInteger b1 = new BigInteger(i1.reverse().toString());
            BigInteger b2 = new BigInteger(i2.reverse().toString());
            BigInteger add = b1.add(b2);
            String s = add.toString();

            ListNode res = new ListNode(-1);
            ListNode dummy = res;
            for (int i = s.length()-1; i >= 0; i--) {
                dummy.next = new ListNode(Integer.parseInt(Character.toString(s.charAt(i))));
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
