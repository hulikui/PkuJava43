/*
*  删除链表中的元素
*
删除链表中等于给定值val的所有节点。

您在真实的面试中是否遇到过这个题？ Yes
样例
给出链表 1->2->3->3->4->5->3, 和 val = 3, 你需要返回删除3之后的链表：1->2->4->5。
* */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }//构造函数的初始化
 * }
 *  public static class Node{
 int value;
 Node next;
 public Node(int n){
 this.value=n;
 this.next=null;
 }
 }
 Node head = new Node(2)
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     * 声明前后两个指针， 相同则修改结点跳过最后一个， 最后再取头结点是否为删除结点再删除
     */
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p.val == q.val){//注意 删除重复链表结点的写法
                q = q.next;
                p.next = q;
            }else{
                p = p.next;
                q = q.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }
}