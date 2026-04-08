//给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。 
//
// 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [2,3,1,3,1,null,1]
//输出：2 
//解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
//     在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排
//列 [1,2,1] 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1,1,3,null,null,null,null,null,1]
//输出：1 
//解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
//     这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
// 
//
// 示例 3： 
//
// 
//输入：root = [9]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 给定二叉树的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 9 
// 
//
// Related Topics 位运算 树 深度优先搜索 广度优先搜索 二叉树 👍 132 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.*;

/**
 * 二叉树中的伪回文路径
 * @author wuou
 * @date 2024-08-17 18:40:55
 */
class P1457_PseudoPalindromicPathsInABinaryTree{
    public static void main(String[] args) {
        //测试代码
//        Solution solution = new P1457_PseudoPalindromicPathsInABinaryTree().new Solution();
//        TreeNode root = new TreeNode();
//        root.val=3;
//        solution.pseudoPalindromicPaths(root);
        System.out.println(0 ^ 1 << 3);
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
    List<String> path = new ArrayList<>();
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root,"");
        int ans = 0;
        for (String str : path) {
            String[] array = str.split("\\$");
            Map<Integer, Integer> map = new HashMap<>();
            for (String i : array) {
                int k = Integer.parseInt(i);
                map.put(k, map.getOrDefault(k,0) + 1);
            }
            if (judge(map,array.length)) {
                ans ++;
            }
        }
        return ans;
    }
    private boolean judge(Map<Integer, Integer> map, int len) {
        if (len % 2 == 0) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return false;
                }
            }
            return true;
        } else {
            int i = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    i ++;
                }
            }
            return i == 1;
        }
    }
    public void dfs(TreeNode root, String str) {
        if (root == null) return;
        str += root.val + "$";
        if (root.left == null && root.right == null) path.add(str);
        dfs(root.left,str);
        dfs(root.right,str);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}