package com.solve.二叉树;

/**
 * @Author Wuou
 * @Date 2021-08-18 22:12
 * @Version V1.0
 **/
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
