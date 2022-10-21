package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree().new Solution();
    }
    /**
     * 另一棵树的子树
     */
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (subRoot == null) {
                return true;
            }
            if (root == null) {
                return false;
            }
            return dfs(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean dfs(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null || root.val != subRoot.val) {
                return false;
            }
            return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
