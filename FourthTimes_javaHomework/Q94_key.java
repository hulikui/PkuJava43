package com.leetcode.homework;

import java.util.List;

public class Q94_key {
	public List<Integer> inorderTraversal(TreeNode root) {
	     List<Integer> result = new java.util.ArrayList<Integer>();
	     inorder(root,result);
	     return result;
	}

	private void inorder(TreeNode root,List<Integer> result){
	   java.util.Stack<TreeNode> stack = new java.util.Stack<TreeNode>();
	   if(root==null) return;
	   if(root.right!=null) stack.push(root.right);
	   stack.push(root);
	   if(root.left!=null) stack.push(root.left);
	   root.left = null;
	   root.right = null;
	   while(!stack.empty()){
	       TreeNode temp = stack.pop();
	       if(temp.left==null&&temp.right==null){
	           result.add(temp.val);
	       }else{
	           if(temp.right!=null) stack.push(temp.right);
	           stack.push(temp);
	           if(temp.left!=null) stack.push(temp.left);
	           temp.left = null;
	           temp.right = null;
	       }
	   }
	}
}
