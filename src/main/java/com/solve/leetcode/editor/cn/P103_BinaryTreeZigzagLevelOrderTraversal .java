//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
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
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 908 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的锯齿形层序遍历
 * @author wuou
 * @date 2024-08-08 20:44:59
 */
class P103_BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P103_BinaryTreeZigzagLevelOrderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        root.left = node1;
        node1.left = node3;
        root.right = node2;
        node2.right = node4;
        solution.zigzagLevelOrder(root);
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) deque.offer(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            int i = deque.size();
            List<Integer> list = new ArrayList<>();
            while (i -- > 0) {
                TreeNode first = deque.pop();
                list.add(first.val);
                if (flag) {
                    if (first.right != null) deque.offer(first.right);
                    if (first.left != null) deque.offer(first.left);
                } else {
                    if (first.left != null) deque.offer(first.left);
                    if (first.right != null) deque.offer(first.right);
                }
            }
            flag = !flag;
            System.out.println("flag="+flag);
            ans.add(list);
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}