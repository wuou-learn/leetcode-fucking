//给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。 
//
// 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。 
//
// 
// 注：字符串中任何较短的前缀在 字典序上 都是 较小 的： 
// 
//
// 
// 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。 
// 
//
// 节点的叶节点是没有子节点的节点。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [0,1,2,3,4,3,4]
//输出："dba"
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [25,1,3,1,3,0,2]
//输出："adz"
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,1,null,1,0,null,0]
//输出："abc"
// 
//
// 
//
// 提示： 
//
// 
// 给定树的结点数在 [1, 8500] 范围内 
// 0 <= Node.val <= 25 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 115 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.HashSet;

/**
 * 从叶结点开始的最小字符串
 * @author wuou
 * @date 2024-08-18 11:58:01
 */
class P988_SmallestStringStartingFromLeaf{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P988_SmallestStringStartingFromLeaf().new Solution();
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
    public String smallestFromLeaf(TreeNode root) {
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}