//给你一棵二叉树，请你返回满足以下条件的所有节点的值之和： 
//
// 
// 该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。） 
// 
//
// 如果不存在祖父节点值为偶数的节点，那么返回 0 。 
//
// 
//
// 示例： 
//
// 
//
// 输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：18
//解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在 1 到 10^4 之间。 
// 每个节点的值在 1 到 100 之间。 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 97 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

/**
 * 祖父节点值为偶数的节点和
 * @author wuou
 * @date 2024-08-17 22:17:14
 */
class P1315_SumOfNodesWithEvenValuedGrandparent{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1315_SumOfNodesWithEvenValuedGrandparent().new Solution();
        TreeNode root = new TreeNode(61);
        TreeNode node1 = new TreeNode(13);
        TreeNode node2 = new TreeNode(46);
        TreeNode node3 = new TreeNode(56);
        TreeNode node4 = new TreeNode(72);
        root.left = node1;
        root.right = node2;
        node2.right = node3;
        node3.left = node4;
        solution.sumEvenGrandparent(root);
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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int left = dfs(root.left, sum);
        int right = dfs(root.right, sum);
        if (root.val % 2 != 0) return sum + left + right;
        if (root.left != null) {
            if (root.left.left != null) {
                sum += root.left.left.val;
            }
            if (root.left.right != null) {
                sum += root.left.right.val;
            }
        }
        if (root.right != null) {
            if (root.right.left != null) {
                sum += root.right.left.val;
            }
            if (root.right.right != null) {
                sum += root.right.right.val;
            }
        }
        return sum + left + right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}