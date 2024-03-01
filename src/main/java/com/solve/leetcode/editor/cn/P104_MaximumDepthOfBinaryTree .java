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
 * @author wuou
 * @date 2024-03-01 21:34:52
 */
class P104_MaximumDepthOfBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P104_MaximumDepthOfBinaryTree().new Solution();
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
	Map<TreeNode, Integer> dist = new HashMap<>();
    public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		arrayDeque.offer(root);
		return bfs();
    }
	public int bfs(){
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
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}