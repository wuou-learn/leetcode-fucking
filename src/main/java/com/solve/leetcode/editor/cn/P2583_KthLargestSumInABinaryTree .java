//给你一棵二叉树的根节点 root 和一个正整数 k 。 
//
// 树中的 层和 是指 同一层 上节点值的总和。 
//
// 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。 
//
// 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,8,9,2,1,3,7,4,6], k = 2
//输出：13
//解释：树中每一层的层和分别是：
//- Level 1: 5
//- Level 2: 8 + 9 = 17
//- Level 3: 2 + 1 + 3 + 7 = 13
//- Level 4: 4 + 6 = 10
//第 2 大的层和等于 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,null,3], k = 1
//输出：3
//解释：最大的层和是 3 。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 
// 2 <= n <= 10⁵ 
// 1 <= Node.val <= 10⁶ 
// 1 <= k <= n 
// 
//
// Related Topics 树 广度优先搜索 二叉树 排序 👍 36 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树中的第 K 大层和
 * @author wuou
 * @date 2024-03-02 13:03:49
 */
class P2583_KthLargestSumInABinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2583_KthLargestSumInABinaryTree().new Solution();
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
    public long kthLargestLevelSum(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}
		ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
		arrayDeque.offer(root);

		List<Long> res = new ArrayList<>();
		int level = 0;
		while (!arrayDeque.isEmpty()) {
			int size = arrayDeque.size();
			long sum = 0L;
			level ++;
			for (int i = 0; i < size; i++) {
				TreeNode poll = arrayDeque.poll();
				if (poll.left != null) {
					arrayDeque.offer(poll.left);
				}
				if (poll.right != null) {
					arrayDeque.offer(poll.right);
				}
				sum += poll.val;
			}
			res.add(sum);
		}

		if (k > level) {
			return -1;
		}
		List<Long> collect = res.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return collect.get(k-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}