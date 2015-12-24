public class Solution {
    public boolean isBalanced(TreeNode root) {
    if(root==null) return true;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        //看根节点左右两颗树的高度，判断是不是balanced；
        //如果balanced，再看左边树跟右边树是不是都balanced;
       

        int diff = Math.abs(getHeight(left) - getHeight(right));
        
        if(diff > 1) return false;
        
       return isBalanced(left) && isBalanced(right);
}
   
public int getHeight(TreeNode root) {
        if(root == null) return 0;
       
       return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
}
}