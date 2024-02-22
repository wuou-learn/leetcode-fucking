package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author  wuou
 * @date    2024-02-22 20:29:58
 */
class Q0102BinaryTreeLevelOrderTraversal {
//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
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
// Related Topics 树 广度优先搜索 二叉树 👍 1901 👎 0
    
public static void main(String[] args) {
    Solution solution = new Q0102BinaryTreeLevelOrderTraversal().new Solution();
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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (Objects.nonNull(root)) {
            arrayDeque.offer(root);
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!arrayDeque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = arrayDeque.size();
            while (size -- > 0) {
                TreeNode t = arrayDeque.poll();
                if (Objects.nonNull(t.left)) {
                    arrayDeque.offer(t.left);
                }
                if (Objects.nonNull(t.right)) {
                    arrayDeque.offer(t.right);
                }
                level.add(t.val);
            }
            res.add(level);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}