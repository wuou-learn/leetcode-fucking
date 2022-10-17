package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new CountCompleteTreeNodes().new Solution();
    }
    /**
     * 完全二叉树的节点个数
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int x = 0, y = 0;
            TreeNode l = root, r = root;
            while (l != null){
                x ++;
                l = l.left;
            }
            while (r != null){
                y ++;
                r = r.right;
            }
            if (x == y) {
                return (1 << x) - 1;
            }
            return countNodes(root.left) + 1 + countNodes(root.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
