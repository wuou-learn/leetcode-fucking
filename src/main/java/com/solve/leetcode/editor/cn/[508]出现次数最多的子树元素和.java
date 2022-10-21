package com.solve.leetcode.editor.cn;

import com.solve.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
    }
    /**
     * 出现次数最多的子树元素和
     */
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        public int[] findFrequentTreeSum(TreeNode root) {
            dfs(root);
            int [] res = new int[ans.size()];
            int i = 0 ;
            for (Integer an : ans) {
                res[i] = an;
                i++;
            }
            return res;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sum = root.val + dfs(root.left) + dfs(root.right);
            map.put(sum, map.getOrDefault(sum, 0)+1);
            if (map.get(sum) > max) {
                max = map.get(sum);
                ans.clear();
                ans.add(sum);
            }else if (map.get(sum) == max) {
                ans.add(sum);
            }
            return sum;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
