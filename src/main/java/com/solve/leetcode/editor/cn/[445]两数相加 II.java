package com.solve.leetcode.editor.cn;


import java.math.BigInteger;

class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        ListNode l3 = new ListNode(4, null);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);

        ListNode a4 = new ListNode(3, null);
        ListNode a3 = new ListNode(4, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(7, a2);
        solution.addTwoNumbers(a1,l1);
        

    }
    /**
     * 两数相加 II
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
            BigInteger b1 = new BigInteger(i1.toString());
            BigInteger b2 = new BigInteger(i2.toString());
            BigInteger add = b1.add(b2);
            String s = add.toString();

            ListNode res = new ListNode(-1);
            ListNode dummy = res;
            for (int i = 0; i< s.length() ; i++) {
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
