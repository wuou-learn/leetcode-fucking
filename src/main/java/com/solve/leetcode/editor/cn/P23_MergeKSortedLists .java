//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2822 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.单链表.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 合并 K 个升序链表
 * @author wuou
 * @date 2024-05-27 19:55:26
 */
class P23_MergeKSortedLists{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P23_MergeKSortedLists().new Solution();
        ListNode listNode1 = new ListNode(2);

        ListNode listNode4 = new ListNode(-1);
        solution.mergeKLists(new ListNode[]{listNode1,null,listNode4});
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /*public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = lists[0];
        for (int i = 1; i < lists.length; i++) {
            curr.next = merge(curr.next, lists[i]);
        }
        return dummy.next;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }*/

    // 优先级队列
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) priorityQueue.offer(list);
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            curr.next = poll;
            curr = curr.next;
            if (poll.next != null) {
                priorityQueue.offer(poll.next);
            }
        }
        return dummy.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}