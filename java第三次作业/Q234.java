package com.leetcode.homework;

public class Q234 {
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
       	return true;
       
       //��������ĳ��ȣ���ȡ��n/2�ĵط�
       int length=1;   //head����ֵ�ģ��ʴ˴��ĳ�����ʱ����Ϊ1
       ListNode nodeHead = head;
       while(nodeHead.next != null) {
       	length++;
       	nodeHead = nodeHead.next;
       }
       
        //��length����������ż���ж�
       boolean isOdd = false;
       if(length%2!=0)  
       	isOdd = true;
       
  //��ǰһ��ı���е�����
       length = length/2;
       //��ʣ��Ľڵ���д���
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
       //��ͷ�ڵ���е����Ĵ���,��ͷ�ڵ��nextָ���м�ڵ�
//     head.next = subNode;   //who care
       
     //���бȽ�(����n��������ż��������)
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
