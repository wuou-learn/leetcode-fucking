//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 845 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.单链表.ListNode;

/**
 * 分隔链表
 * @author wuou
 * @date 2024-07-13 15:29:33
 */
class P86_PartitionList{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P86_PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        /**
         * 遍历链表
         * 定义左右两个链表
         * 将大于x的插入右链表尾节点
         * 将小于x的插入左链表尾节点
         */
        ListNode lh = new ListNode(-1);
        ListNode rh = new ListNode(-1);
        ListNode lt = lh;
        ListNode rt = rh;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                lt = lt.next = p;
            } else {
                rt = rt.next = p;
            }
        }
        lt.next = rh.next;
        rt.next = null;
        return lh.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}