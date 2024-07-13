//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1303 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.单链表.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * @author wuou
 * @date 2024-07-12 11:18:27
 */
class P82_RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        solution.deleteDuplicates(listNode1);
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
    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 1.去除重复元素
         * 2.
         * 3.
         */

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            ListNode q = p.next.next;
            while (q != null && p.next.val == q.val) {
                q = q.next;
            }
            if (p.next.next == q) {
                p = p.next;
            } else {
                p.next = q;
            }
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}