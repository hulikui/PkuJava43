/*
*  在二叉查找树中插入节点

给定一棵二叉查找树和一个新的树节点，将节点插入到树中。

你需要保证该树仍然是一棵二叉查找树。

 注意事项

You can assume there is no duplicate values in this tree + node.

样例
给出如下一棵二叉查找树，在插入节点6之后这棵二叉查找树可以是这样的：

  2             2
 / \           / \
1   4   -->   1   4
   /             / \
  3             3   6
* */

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
 * @param root: The root of the binary search tree.
 * @param node: insert this node into the binary search tree
 * @return: The root of the new binary search tree.
 * 查找二叉树的规律是 左小又大
 * 二叉树一般用：递归方法 结束条件是 插入叶子结点或者返回有相同值的结点
 */
    public TreeNode inertNode(TreeNode root, TreeNode node){
        // 递归思想 先解决一层
        if(root == null) root = node;
        if(root.val == node.val) return root;
        if(root.val > node.val)
            root.left = inertNode(root.left, node);
        if(root.val < node.val)
            root.right = inertNode(root.right, node);
        return root;
    }

}