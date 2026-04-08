//给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下： 
//
// 
// 选择二叉树中 任意 节点和一个方向（左或者右）。 
// 如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。 
// 改变前进方向：左变右或者右变左。 
// 重复第二步和第三步，直到你在树中无法继续移动。 
// 
//
// 交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。 
//
// 请你返回给定树中最长 交错路径 的长度。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
//输出：3
//解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,1,1,null,1,null,null,1,1,null,1]
//输出：4
//解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
// 
//
// 示例 3： 
//
// 输入：root = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 50000 个节点。 
// 每个节点的值在 [1, 100] 之间。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 175 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;
import com.solve.utils.TreeBuilder;

/**
 * 二叉树中的最长交错路径
 * @author wuou
 * @date 2024-08-19 20:57:02
 */
class P1372_LongestZigzagPathInABinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1372_LongestZigzagPathInABinaryTree().new Solution();

        TreeNode root = TreeBuilder.arrayToTree(new Integer[]{1,2,3,null,null,7,8});
        solution.longestZigZag(root);
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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root.left,0,1);
        dfs(root.right,1,1);
        return max;
    }
    public void dfs(TreeNode root, int d, int u) {
        if (root == null) return;
        max = Math.max(u, max);
        if (d == 0) {
            dfs(root.right, 1, u + 1);
            dfs(root.left, 0, 1);
        } else {
            dfs(root.left, 0, u + 1);
            dfs(root.right, 1, 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}