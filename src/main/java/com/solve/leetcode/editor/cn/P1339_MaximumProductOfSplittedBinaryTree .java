//给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。 
//
// 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [1,2,3,4,5,6]
//输出：110
//解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,null,2,3,4,null,null,5,6]
//输出：90
//解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
// 
//
// 示例 3： 
//
// 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
//输出：1025
// 
//
// 示例 4： 
//
// 输入：root = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 50000 个节点，且至少有 2 个节点。 
// 每个节点的值在 [1, 10000] 之间。 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 106 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

/**
 * 分裂二叉树的最大乘积
 * @author wuou
 * @date 2024-08-27 21:04:55
 */
class P1339_MaximumProductOfSplittedBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P1339_MaximumProductOfSplittedBinaryTree().new Solution();
        System.out.println(11/2);
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
    int MOD = (int) 1e9 + 7;
    int total = 0;
    long ans = 0;
    public int maxProduct(TreeNode root) {
        total = dfs(root);
        dfs(root);
        return (int) ans % MOD;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int sum = root.val;
        sum += dfs(root.left) + dfs(root.right);
        ans = Math.max(ans, sum * (total - sum));
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}