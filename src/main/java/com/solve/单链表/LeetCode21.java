package com.solve.单链表;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/20 上午11:16
 * @Version 1.0.0
 */
public class LeetCode21 {



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tmp = null;
        if(l1.val < l2.val){
            tmp = l1.next;
            l1.next = l2;
            mergeTwoLists(tmp, l2);
            return l2;
        }else {
            mergeTwoLists(l1, l2.next);
            return l1;
        }
    }
}
