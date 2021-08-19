package com.solve.二叉树;

/**
 * @Description
 * @Author wuou
 * @Date 2021/8/19 上午10:06
 * @Version 1.0.0
 */
public class LeetCode116 {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        change(root.left,root.right);
        return root;
    }

    private void change(Node node1, Node node2){
        if(node1 == null || node2 ==null){
            return;
        }
        node1.next = node2;
        change(node1.left,node1.right);
        change(node2.left,node2.right);
        change(node1.right,node2.left);
    }
}
