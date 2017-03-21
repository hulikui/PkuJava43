/*
*
*  平衡二叉树

给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。

样例
给出二叉树 A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

A)  3            B)    3
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
二叉树A是高度平衡的二叉树，但是B不是
*
* */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 */
public class Solution {
/**
 * @param root: The root of binary tree.
 * @return: True if this Binary tree is Balanced, or false.
 */
    // 求数高的同时 计算左右子树高是否相差1以上
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        int left = getHeight(root.left);
        if(left == -1) return -1;
        int right = getHeight(root.right);
        if(right == -1) return -1;
        int diff = left - right;
        if(Math.abs(diff) > 1) return -1;
        return diff > 0 ? Math.max(left, left + 1) : Math.max(right, right + 1);// 返回树的高度
    }
    public boolean isBalanced(TreeNode root){
        if(getHeight(root) == -1) return false;
        return true;
    }
}