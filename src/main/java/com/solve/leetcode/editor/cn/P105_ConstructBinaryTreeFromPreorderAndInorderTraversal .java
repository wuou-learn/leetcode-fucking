//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2692 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

import static com.solve.leetcode.editor.cn.P3243_ShortestDistanceAfterRoadAdditionQueriesI.dfs;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author wuou
 * @date 2026-03-09 11:30:34
 */
class P105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
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
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight) {
        if (preorderLeft > preorderRight || inorderLeft > inorderRight) {
            return null;
        }
        int rootVal = preorder[preorderLeft];
        Integer rootIdx = map.get(rootVal);
        int leftLen = rootIdx - inorderLeft;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(preorder, inorder,
                preorderLeft + 1, preorderLeft + leftLen,
                inorderLeft, rootIdx);
        root.right = dfs(preorder, inorder,
                preorderLeft + leftLen + 1, preorderRight,
                rootIdx + 1, inorderRight);

        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}