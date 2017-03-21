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
 * 需要借助一个队列记忆父节点层次,以便回溯
 */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new Queue<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){// 每一层的父亲节点
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}