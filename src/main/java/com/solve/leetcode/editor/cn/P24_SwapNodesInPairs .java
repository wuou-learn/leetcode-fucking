//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2212 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.单链表.ListNode;

/**
 * 两两交换链表中的节点
 * @author wuou
 * @date 2024-05-27 20:47:17
 */
class P24_SwapNodesInPairs{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P24_SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        for (ListNode p = dummy; p.next !=null && p.next.next != null;) {
            ListNode a = p.next;
            ListNode b = a.next;
            p.next = b;
            a.next = b.next;
            b.next = a;
            p = a;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}