//给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和
// targetSum 。如果存在，返回 true ；否则，返回 false 。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
//输出：true
//解释：等于目标和的根节点到叶节点路径如上图所示。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3], targetSum = 5
//输出：false
//解释：树中存在两条根节点到叶子节点的路径：
//(1 --> 2): 和为 3
//(1 --> 3): 和为 4
//不存在 sum = 5 的根节点到叶子节点的路径。 
//
// 示例 3： 
//
// 
//输入：root = [], targetSum = 0
//输出：false
//解释：由于树是空的，所以不存在根节点到叶子节点的路径。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1380 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

/**
 * 路径总和
 * @author wuou
 * @date 2024-08-13 20:31:29
 */
class P112_PathSum{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P112_PathSum().new Solution();
        TreeNode root = new TreeNode();
        root.val=1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val=2;
//        TreeNode treeNode2 = new TreeNode();
//        treeNode2.val=20;
//        TreeNode treeNode3 = new TreeNode();
//        treeNode3.val=15;
//        TreeNode treeNode4 = new TreeNode();
//        treeNode4.val=7;
        root.left = treeNode1;
//        root.right = treeNode2;
//        treeNode2.left = treeNode3;
//        treeNode2.right = treeNode4;
        solution.hasPathSum(root,1);
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
    boolean res = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return dfs(root,targetSum,0);
    }
    public boolean dfs(TreeNode root, int targetSum, int sum) {
        if (res || root == null) return res;
        sum += root.val;
        if (root.left == null && root.right == null) {
            res = sum == targetSum;
            return res;
        }

        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}