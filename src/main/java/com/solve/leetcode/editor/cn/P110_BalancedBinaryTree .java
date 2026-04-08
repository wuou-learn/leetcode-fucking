//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1487 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;
import com.solve.utils.TreeBuilder;

import java.math.BigDecimal;

/**
 * 平衡二叉树
 * @author wuou
 * @date 2024-03-02 15:15:00
 */
class P110_BalancedBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P110_BalancedBinaryTree().new Solution();
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
//        solution.isBalanced(root);
        solution.isBalanced(TreeBuilder.arrayToTree(new Integer[]{1,2,3,4,5,6,null,8}));
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
    public int res = -1;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root, 0);
        return res == 1;
    }
    public int dfs(TreeNode root, int level) {
        if (root == null) return 0;
        if (root.left == root.right) return level;
        int maxLeft = dfs(root.left,level+1);
        int maxRight = dfs(root.right,level+1);
        System.out.println("root="+root.val+" maxLeft ="+maxLeft + " maxRight ="+maxRight);
        if (res == -1 || res == 1) {
            res = Math.abs(maxRight - maxLeft) <= 1 ? 1 : 0;
        }
        return Math.max(maxLeft,maxRight);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}