package com.leetcode.homework;

import java.util.LinkedList;

public class Q111 {
	//层次遍历，第一个缺少叶子节点的即为最小深度,使用数据结构为队列
    public int minDepth(TreeNode root) {
        int num = 0;
        if(root == null){
        	return num;
        }
        
        LinkedList<TreeNode> tempList = new LinkedList<TreeNode>();
        tempList.addFirst(root);
        num++;
        TreeNode firstLevelNode = root; 
        while(tempList.size()!=0){
        	TreeNode node = tempList.removeLast();
        	if(node.left==null&&node.right==null){
        		if(node!=firstLevelNode)
        			num--;
        		break;
        	}
        	if(node==firstLevelNode){
        		if(node.left!=null){
        			firstLevelNode = node.left;
        		}else if(node.right!=null){
        			firstLevelNode = node.right;
        		}
        		num++;
        	}
        	
        	if(node.left!=null)
        		tempList.addFirst(node.left);
        	if(node.right!=null)
        		tempList.addFirst(node.right);
        }
        return num;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
        root.left=n1;
        root.right=n2;
        n1.right=n3;
        n1.left=n4;
        n2.left=n5;
		
		Q111 q = new Q111();
		int num = q.minDepth(root);
		System.out.println(num);
	}
}
