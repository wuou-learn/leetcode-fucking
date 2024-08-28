//给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。 
//
// 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4]
//输出："1(2(4))(3)"
//解释：初步转化后得到 "1(2(4)())(3()())" ，但省略所有不必要的空括号对后，字符串应该是"1(2(4))(3)" 。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,3,null,4]
//输出："1(2()(4))(3)"
//解释：和第一个示例类似，但是无法省略第一个空括号对，否则会破坏输入与输出一一映射的关系。 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是 [1, 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 字符串 二叉树 👍 401 👎 0


package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;
import com.solve.utils.TreeBuilder;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 根据二叉树创建字符串
 * @author wuou
 * @date 2024-08-25 20:21:09
 */
class P606_ConstructStringFromBinaryTree{
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P606_ConstructStringFromBinaryTree().new Solution();
        solution.tree2str(TreeBuilder.arrayToTree(new Integer[]{1,2,3,null,4}));
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
    String ans = "";
    public String tree2str(TreeNode root) {
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root) {
        if (root == null) return ;
        ans += root.val;
        if (root.left != null || root.right != null) {
            ans += "(";
            dfs(root.left);
            ans += ")";
        }
        if (root.right != null) {
            ans += "(";
            dfs(root.right);
            ans += ")";
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}