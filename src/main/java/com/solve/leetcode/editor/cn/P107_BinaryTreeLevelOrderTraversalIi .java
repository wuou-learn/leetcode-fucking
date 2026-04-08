//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 806 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 二叉树的层序遍历 II
 * @author wuou
 * @date 2024-08-08 21:02:48
 */
class P107_BinaryTreeLevelOrderTraversalIi{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P107_BinaryTreeLevelOrderTraversalIi().new Solution();
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.offer(root);
        List<List<Integer>> ans = new ArrayList<>();

        while (!deque.isEmpty()) {
            int i = deque.size();
            List<Integer> list = new ArrayList<>();
            while (i-- > 0) {
                TreeNode first = deque.pop();
                list.add(first.val);
                if (first.left != null) deque.offer(first.left);
                if (first.right != null) deque.offer(first.right);
            }
            ans.add(list);
        }
        Collections.reverse(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}