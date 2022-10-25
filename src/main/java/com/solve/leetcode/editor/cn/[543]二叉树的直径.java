package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

class DiameterOfBinaryTree{
  public static void main(String[] args) {
       Solution solution = new DiameterOfBinaryTree().new Solution();
  }
  /**
   * 二叉树的直径
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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        ans = Math.max(l+r, ans);
        return Math.max(l, r)+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
