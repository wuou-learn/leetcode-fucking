//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2057 👎 0


package com.solve.leetcode.editor.cn;


import com.solve.common.TreeNode;
import sun.util.logging.PlatformLogger;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 翻转二叉树
 * @author wuou
 * @date 2026-03-04 16:59:34
 */
class P226_InvertBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P226_InvertBinaryTree().new Solution();
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                TreeNode temp = poll.left;
                poll.left = poll.right;
                poll.right = temp;

                if (poll.left != null) deque.offer(poll.left);
                if (poll.right != null) deque.offer(poll.right);
            }
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}