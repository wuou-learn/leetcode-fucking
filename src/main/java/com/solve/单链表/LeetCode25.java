package com.solve.单链表;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/17 下午5:51
 * @Version 1.0.0
 */
public class LeetCode25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        for(int i = 0; i<k; i++){
            if(b == null){
                return head;
            }
            b = b.next;
        }
        ListNode last = reverse(a,b);
        a.next = reverseKGroup(b,k);
        return last;
    }

    public ListNode reverse(ListNode a, ListNode b){
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;
        while(cur != b){
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

}
