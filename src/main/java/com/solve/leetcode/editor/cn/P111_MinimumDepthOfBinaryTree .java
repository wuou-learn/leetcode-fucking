//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
//
/**
 *     3
 *    9 20
 *      15 7
 */
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
//
/**
 * [1,2,3,4,null,null,5]
 *       1
 *     2    3
 *   4         5
 *
 *
 */
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1160 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;

/**
 * 二叉树的最小深度
 * @author wuou
 * @date 2024-03-04 10:14:09
 */
class P111_MinimumDepthOfBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P111_MinimumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.right = treeNode4;
        solution.minDepth(root);
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
    ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        arrayDeque.offer(root);
        int level = 0;
        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = arrayDeque.poll();
                if (level > 1 && poll.left == null && poll.right == null) {
                    return level;
                }
                if (poll.left != null) {
                    arrayDeque.offer(poll.left);
                }
                if (poll.right != null) {
                    arrayDeque.offer(poll.right);
                }
            }
        }
        return level;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}