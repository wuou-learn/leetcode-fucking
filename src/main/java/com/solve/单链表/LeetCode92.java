package com.solve.单链表;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/17 下午5:51
 * @Version 1.0.0
 */
public class LeetCode92 {

    public static void main(String[] args) {
        int [] arr = new int[5];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;
        solve(arr,2);
    }

    public static void solve(int []arr, int k){
        int res []=new int[k];
        for(int i=1;i<=arr.length;i++){
            res[((i-1)%k)] =i;
            if(i%k==0){
                res = new int[k];
            }
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == 1){
            return revereRight(head,right);
        }
        head.next = reverseBetween(head.next,left-1,right-1);
        return head;
    }

    static ListNode successor = null;
    private static ListNode revereRight(ListNode head, int right) {
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
