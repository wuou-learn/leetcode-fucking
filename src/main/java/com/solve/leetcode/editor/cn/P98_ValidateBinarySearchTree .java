//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2282 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

/**
 * 验证二叉搜索树
 * @author wuou
 * @date 2024-03-03 15:37:22
 */
class P98_ValidateBinarySearchTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P98_ValidateBinarySearchTree().new Solution();
        TreeNode root = new TreeNode();
        root.val = -2147483648;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2147483647;
        /*TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 4;*/
        /*TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 3;
        TreeNode treeNode4 = new TreeNode();
        treeNode3.val = 6;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;*/
        root.right = treeNode1;
//        root.left = treeNode1;
        solution.isValidBST(root);
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

    // 中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return true;
        }
        return dfs(root);
    }
    long pre = Long.MIN_VALUE;
    public boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return dfs(root.right);
    }

    /*// 前序遍历，左中右
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        return (root.val > left && root.val < right) && dfs(root.left, left, root.val) && dfs(root.right, root.val, right);
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}