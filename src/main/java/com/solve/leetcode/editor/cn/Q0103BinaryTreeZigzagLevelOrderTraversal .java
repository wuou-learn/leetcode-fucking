package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  wuou
 * @date    2024-02-22 21:01:13
 */
class Q0103BinaryTreeZigzagLevelOrderTraversal {
//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 862 👎 0
    
public static void main(String[] args) {
    Solution solution = new Q0103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        if (root != null) {
            arrayDeque.offer(root);
        }
        List<List<Integer>> res = new ArrayList<>();
        int idx = 0;
        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            List<Integer> level = new ArrayList<>();
            while (size -- > 0) {
                TreeNode t = arrayDeque.poll();
                if (t.left != null) {
                    arrayDeque.offer(t.left);
                }
                if (t.right != null) {
                    arrayDeque.offer(t.right);
                }

                level.add(t.val);
            }
            if (++idx % 2 == 0) {
                Collections.reverse(level);
            }
            res.add(level);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}