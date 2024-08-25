package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  wuou
 * @date    2024-02-22 20:48:41
 */
class Q0107BinaryTreeLevelOrderTraversalIi {
//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
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
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 783 👎 0
    
public static void main(String[] args) {
    Solution solution = new Q0107BinaryTreeLevelOrderTraversalIi().new Solution();
}
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root != null) {
                arrayDeque.offer(root);
            }

            while (!arrayDeque.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = arrayDeque.size();
                while (size -- > 0) {
                    TreeNode t = arrayDeque.pop();
                    if (t.left != null) {
                        arrayDeque.offer(t.left);
                    }
                    if (t.right != null) {
                        arrayDeque.offer(t.right);
                    }
                    level.add(t.val);
                }
                res.add(level);
            }

            Collections.reverse(res);
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}