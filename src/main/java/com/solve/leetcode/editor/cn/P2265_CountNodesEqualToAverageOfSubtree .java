//给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。 
//
// 注意： 
//
// 
// n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。 
// root 的 子树 由 root 和它的所有后代组成。 
// 
//
// 
//
// 示例 1： 
// 输入：root = [4,8,5,0,1,null,6]
//输出：5
//解释：
//对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
//对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
//对值为 0 的节点：子树的平均值 0 / 1 = 0 。
//对值为 1 的节点：子树的平均值 1 / 1 = 1 。
//对值为 6 的节点：子树的平均值 6 / 1 = 6 。
// 
//
// 示例 2： 
// 输入：root = [1]
//输出：1
//解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// 0 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 40 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;
import javafx.util.Pair;

/**
 * 统计值等于子树平均值的节点数
 * @author wuou
 * @date 2024-08-25 20:56:27
 */
class P2265_CountNodesEqualToAverageOfSubtree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P2265_CountNodesEqualToAverageOfSubtree().new Solution();
        long num1 = 1000; // 取值范围：0-15 (4 bits)
        long num2 = 288; // 取值范围：0-15 (4 bits)

        long combined = (num1 << 32) | num2 & 0xFFFFFFFFL;

        // 提取num1
        long extractedNum1 = (combined >> 32) & 0xFFFFFFFFL;

        // 提取num2
        long extractedNum2 = combined & 0xFFFFFFFFL;

        System.out.println("Combined: " + combined);
        System.out.println("Extracted num1: " + extractedNum1);
        System.out.println("Extracted num2: " + extractedNum2);
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
    int ans = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftSum = left & 0xFFFF;
        int rightSum = right & 0xFFFF;

        int leftNum = (left >> 16) & 0xFFFF;
        int rightNum = (right >> 16) & 0xFFFF;
        int rootSum = root.val + leftSum + rightSum;
        int rootNum = leftNum + rightNum + 1;
        return (rootNum << 16) | rootSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}