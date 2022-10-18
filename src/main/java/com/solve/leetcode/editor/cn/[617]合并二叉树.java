package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new MergeTwoBinaryTrees().new Solution();
    }
    /**
     * 合并二叉树
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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root2 != null) {
                TreeNode temp = root1;
                root1 = root2;
                root2 = temp;
            }
            if (root1 == null) {
                return null;
            }
            if (root2 != null) {
                root1.val += root2.val;
            }
            root1.left = mergeTrees(root1.left,root2 == null? null : root2.left);
            root1.right = mergeTrees(root1.right,root2 == null? null : root2.right);
            return root1;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
