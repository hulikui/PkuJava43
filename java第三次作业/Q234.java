package com.leetcode.homework;

public class Q234 {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
       	return true;
       
       //明白链表的长度，截取到n/2的地方
       int length=1;   //head是有值的，故此处的长度暂时设置为1
       ListNode nodeHead = head;
       while(nodeHead.next != null) {
       	length++;
       	nodeHead = nodeHead.next;
       }
       
        //对length进行奇数和偶数判断
       boolean isOdd = false;
       if(length%2!=0)  
       	isOdd = true;
       
  //对前一半的表进行倒序处理
       length = length/2;
       //对剩余的节点进行处理
       ListNode preNode = null;
       ListNode subNode = head.next;
       ListNode node = head;
       while(length != 0){
       	node.next = preNode;
       	preNode = node;
       	node = subNode;
       	subNode = subNode.next;
       	length--;
       }
       //对头节点进行单独的处理,将头节点的next指向中间节点
//     head.next = subNode;   //who care
       
     //进行比较(存在n的奇数和偶数的问题)
     if(isOdd)
   	  node = node.next;
	  while(node != null){
		  if(preNode.val != node.val)
			  return false;
		  preNode = preNode.next;
		  node = node.next;
	  }
     
     return true;
   }
}
