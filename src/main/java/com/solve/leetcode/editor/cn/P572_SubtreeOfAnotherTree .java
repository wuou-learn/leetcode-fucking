//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
// 
// 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 👍 1088 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;
import com.solve.utils.TreeBuilder;

/**
 * 另一棵树的子树
 * @author wuou
 * @date 2024-08-28 19:40:40
 */
class P572_SubtreeOfAnotherTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P572_SubtreeOfAnotherTree().new Solution();
        solution.isSubtree(TreeBuilder.arrayToTree(new Integer[]{3,4,5,1,2}), TreeBuilder.arrayToTree(new Integer[]{4,1,2}));
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (dfs(root,subRoot)) return true;
        if (root != null && subRoot == null) return false;
        if (root == null) return false;
        System.out.println("r="+root.val+"sub="+subRoot.val);
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == subRoot) return true;
        if (root != null && subRoot == null) return false;
        if (root == null) return false;
        if (root.val != subRoot.val) return false;
        return dfs(root.left, subRoot.left) && dfs(root.right, subRoot.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}