//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 562 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 找树左下角的值
 * @author wuou
 * @date 2024-03-03 15:22:41
 */
class P513_FindBottomLeftTreeValue{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P513_FindBottomLeftTreeValue().new Solution();
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
        solution.findBottomLeftValue(root);
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
    ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int size = arrayDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = arrayDeque.poll();
                if (i == 0) {
                    res.add(poll.val);
                }
                if (poll.left != null) {
                    arrayDeque.offer(poll.left);
                }
                if (poll.right != null) {
                    arrayDeque.offer(poll.right);
                }
            }
        }
        return res.get(res.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}