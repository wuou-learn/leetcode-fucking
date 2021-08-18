package com.solve.单链表;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/17 下午5:51
 * @Version 1.0.0
 */
public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null){
            return head;
        }
        return null;
    }

    static ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode [] listNodes = new ListNode[5];
        listNodes[0] = new ListNode(1,listNodes[1]);
        listNodes[1] = new ListNode(7,listNodes[2]);
        listNodes[2] = new ListNode(9,listNodes[3]);
        listNodes[3] = new ListNode(10,listNodes[4]);
        listNodes[4] = new ListNode(20,null);

        for(int i =0; i<5; i++){
            reverse(listNodes[i]);
        }
    }
}
