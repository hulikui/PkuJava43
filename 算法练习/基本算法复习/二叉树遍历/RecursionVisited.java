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
     * @return: Level order a list of lists of integer
     *
     */
    public void inOrderVisited(ArrayList<Integer> res, TreeNode root){
        if(root == null) return;
        if(root.left != null) inorderTraversal(res, root.left);
        res.add(root.val);//中序遍历在中间 其他序列遍历调整位置即可
        if(root.right != null) inorderTraversal(res, root.right);
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        inOrderVisited(res, root);
        return res;
    }
}