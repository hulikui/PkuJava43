/**
 * 二叉树的最小深度

 给定一个二叉树，找出其最小深度。

 二叉树的最小深度为根节点到最近叶子节点的距离。

 样例
 给出一棵如下的二叉树:

 1

 /     \

 2       3

 /    \

 4      5

 这个二叉树的最小深度为 2
 */
/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     * 递归计算左右子树的高度
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
        return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
    }
}