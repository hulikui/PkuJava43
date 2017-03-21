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
 * @param root the root of the binary tree
 * @return all root-to-leaf paths
 * 核心还是二叉树递归 结束条件是 叶子结点
 */
    public void setPathByEnd(TreeNode root, ArrayList<String> res, String path){
        if(root.left == null && root.right == null) res.add(path);
        if(root.left != null){
            setPathByEnd(root.left, res, path + "->" + root.left.val);
        }
        if(root.right != null){
            setPathByEnd(root.right, res, path + "->" + root.right.val);
        }
    }

    public ArrayList<String> binaryTreePaths(TreeNode root){
        ArrayList<String> res = new ArrayList<>();
        if(root == null) return res;
        setPathByEnd(root, res, String.valueOf(root.val));
        return res;
    }
}