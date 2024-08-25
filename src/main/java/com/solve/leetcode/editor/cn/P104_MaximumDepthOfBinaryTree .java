//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1784 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 二叉树的最大深度
 *
 * @author wuou
 * @date 2024-03-01 21:34:52
 */
class P104_MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
        TreeNode root = new TreeNode();
        root.val=3;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val=9;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val=20;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val=15;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val=7;
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        solution.maxDepth(root);
    }

//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
        /*int res = 0;
        public int maxDepth(TreeNode root) {
            int level = 0;
            dfs(root, level);
            return res;
        }

        public int dfs(TreeNode root, int level) {
            if (root == null) {
                return level;
            }
            level++;
            res = Math.max(level, res);
            dfs(root.left, level);
            dfs(root.right, level);
            return level;
        }*/
    /*public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/
	/*public int bfs(){
		int level = 0;
		while (!arrayDeque.isEmpty()) {
			level++;
			int size = arrayDeque.size();
			for (int i = 0; i < size; i++) {
				TreeNode poll = arrayDeque.poll();
				if (poll.left != null) {
					arrayDeque.offer(poll.left);
				}
				if (poll.right != null) {
					arrayDeque.offer(poll.right);
				}
			}
		}
		return level;
	}*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}