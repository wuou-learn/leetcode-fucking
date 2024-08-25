//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2863 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.单链表.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删除链表的倒数第 N 个结点
 * @author wuou
 * @date 2024-05-22 20:11:38
 */
class P19_RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = null;
        solution.removeNthFromEnd(l1,1);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        List<ListNode> indexListNode = new ArrayList<>();
        while (head != null) {
            indexListNode.add(head);
            head = head.next;
        }
        int i = indexListNode.size() - n - 1;
        if (i >= 0 && i < indexListNode.size()) {
            ListNode l = indexListNode.get(i);
            l.next = l.next.next;
        }
        if (i < 0) {
            res = res.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}