//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 👍 1135 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.单链表.ListNode;

/**
 * 删除排序链表中的重复元素
 * @author wuou
 * @date 2024-07-13 14:13:46
 */
class P83_RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
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
        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            while (p.next != null && p.val == p.next.val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}