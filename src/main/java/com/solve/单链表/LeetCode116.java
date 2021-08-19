package com.solve.单链表;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/19 下午3:11
 * @Version 1.0.0
 */
public class LeetCode116 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode a = headA;
       ListNode b = headB;
       while (a != b){
           a = a != null ? a.next : headB;
           b = b != null ? b.next : headA;
       }
       return a;
    }



}
