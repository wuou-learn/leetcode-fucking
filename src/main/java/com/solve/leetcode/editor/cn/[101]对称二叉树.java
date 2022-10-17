package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class SymmetricTree{
  public static void main(String[] args) {
       Solution solution = new SymmetricTree().new Solution();
  }
  /**
   * 对称二叉树
   */
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        if (left== null ||  right == null || left.val != right.val) {
            return false;
        }
        return dfs(left.right, right.left) && dfs(left.left, right.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
