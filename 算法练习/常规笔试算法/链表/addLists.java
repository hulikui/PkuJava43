/*
*  链表求和

你有两个用链表代表的整数，其中每个节点包含一个数字。数字存储按照在原来整数中相反的顺序，使得第一个数字位于链表的开头。写出一个函数将两个整数相加，用链表形式返回和。
样例
给出两个链表 3->1->5->null 和 5->9->2->null，返回 8->0->8->null
*
* */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
/**
 * @param l1: the first list
 * @param l2: the second list
 * @return: the sum list of l1 and l2
 * 两个链表元素同时相加， 谁长就返回哪个链表
 */
    public ListNode addLists(ListNode l1, ListNode l2){
        int sum = 0; // 进位 和 和
        ListNode p = l1, p1 = l1;// p 遍历 p1保证p的前一个结点 不为空
        ListNode q = l2, q2 = l2;
        int len1 = 0;
        int len2 = 0;
        while(p != null || q != null){
            if(p != null){
                sum += p.val;
                p = p.next;
                len1++;
            }
            if(q != null){
                sum += q.val;

                len2++;
            }
            // 进位检查, 同时更新
            if(sum > 9){
                p.val = sum % 10;
                q.val = sum % 10;
                sum = sum / 10;
            }else{
                p.val = sum;
                q.val = sum;
                sum = 0;
            }
            if(p != null){
               p1 = p;
               p = p.next;
            }
            if(q != null){
                q1 = q;
                q = q.next;
            }
        }
        // 返回链表长的一方
        if(len1 > len2){
            // 有进位需要增加新结点
            if(sum > 0){
                ListNode m = new ListNode(sum);
                p1.next = m;
            }
            return l1;
        }else{
            if(sum > 0){
                ListNode m = new ListNode(sum);
                p2.next = m;
            }
            return l2;
        }
    }
}