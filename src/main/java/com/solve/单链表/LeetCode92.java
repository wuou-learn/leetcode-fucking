package com.solve.单链表;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/17 下午5:51
 * @Version 1.0.0
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return revereRight(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    ListNode successor = null;
    private ListNode revereRight(ListNode head, int right) {
        if(right == 1){
            successor = head.next;
            return head;
        }
        ListNode last = revereRight(head.next, right - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
