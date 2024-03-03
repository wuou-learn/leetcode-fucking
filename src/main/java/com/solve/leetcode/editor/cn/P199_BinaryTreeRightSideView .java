//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1036 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的右视图
 * @author wuou
 * @date 2024-03-03 14:10:29
 */
class P199_BinaryTreeRightSideView{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P199_BinaryTreeRightSideView().new Solution();
        TreeNode root = new TreeNode();
        root.val=3;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val=9;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val=20;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val=15;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val=7;
        root.left = treeNode1;
        root.right = treeNode2;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        solution.rightSideView(root);
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
    List<Integer> res = new ArrayList<>();
    /*public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }
    int h = 0;
    public void dfs(TreeNode root, int level) {
        if (root == null) {
            return ;
        }
        h = Math.max(level, h);
        if (h == res.size()) {
            res.add(root.val);
        }
        level++;
        dfs(root.right, level);
        dfs(root.left, level);
    }*/

    ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return res;
        }
        arrayDeque.offer(root);
        bfs();
        return res;
    }
    public void bfs() {
        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = arrayDeque.poll();
                if (poll.left != null) {
                    arrayDeque.offer( poll.left);
                }
                if (poll.right != null) {
                    arrayDeque.offer( poll.right);
                }
                if (i == size - 1) {
                    res.add(poll.val);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}