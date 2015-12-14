package com.leetcode.homework;

import java.util.LinkedList;

public class Q226 {
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
    		return null;
         //用来存储遍历的中间点
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
    	while(!queue.isEmpty()){
    		TreeNode node = queue.removeFirst();
    		TreeNode temp = node.right;
    		node.right = node.left;
    		node.left = temp;
    		if(node.left!=null)
    		    queue.addLast(node.left);
    		if(node.right!=null)
    		    queue.addLast(node.right);
    	}
    	
    	return root;
    }
}
