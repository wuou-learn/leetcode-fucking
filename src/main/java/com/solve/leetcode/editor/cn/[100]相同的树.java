package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class SameTree {
    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();
    }
    /**
     * 相同的树
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
