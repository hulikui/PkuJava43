package com.leetcode.homework;

public class Q237 {
    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.next = nextNode.next;
    	node.val = nextNode.val;
    }
    
    public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		deleteNode(node2);
		
		ListNode node = node1;
		while(node!=null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}


 class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
 }
