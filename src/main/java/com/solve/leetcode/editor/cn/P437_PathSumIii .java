//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 2248 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.rmi.MarshalledObject;
import java.util.HashMap;


/**
 * 路径总和 III
 * @author wuou
 * @date 2026-03-10 11:09:28
 */
class P437_PathSumIii{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P437_PathSumIii().new Solution();
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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L,1);
        return dfs(root, targetSum, 0L, map);
    }

    private int dfs(TreeNode root, int targetSum, Long currSum, HashMap<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        currSum += root.val;
        Long preSum = currSum - targetSum;
        int count = map.getOrDefault(preSum, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += dfs(root.left, targetSum, currSum, map);
        count += dfs(root.right, targetSum, currSum, map);

        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
        return count;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}