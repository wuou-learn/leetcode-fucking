package com.solve.单链表;

/**
 * @Description 回文链表
 * @Author wuou
 * @Date 2021/8/18 下午2:25
 * @Version 1.0.0
 */
public class LeetCode234 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        listNode.val=1;
        listNode1.val=2;
        listNode2.val=2;
        listNode3.val=1;
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        boolean palindrome = isPalindrome(listNode);
        System.out.println(palindrome);
    }

    // 左侧指针
    static ListNode left;

    static boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    static boolean traverse(ListNode right) {
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }


}
