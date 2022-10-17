package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class BinaryTreeTilt {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeTilt().new Solution();
    }
    /**
     * 二叉树的坡度
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
        int res = 0;
        public int findTilt(TreeNode root) {
            dfs(root);
            return res;
        }
        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            res += Math.abs(left-right);
            return left + right + root.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
