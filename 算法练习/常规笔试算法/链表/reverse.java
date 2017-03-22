/**
 *
 *  翻转链表

 翻转一个链表

 样例
 给出一个链表1->2->3->null，这个翻转后的链表为3->2->1->null

 */
/
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     * 定义三个指针，每次遍历就交换 p q m 分别是 前 中 后 三个结点
     * 翻转操作：
     * q.next = p;// 每次只修改第一个结点的翻转， 其他继续往下遍历
     * p = q;
     * q = m
     * m = m.next;
     * 处理尾部结点
     * q.next = p;
     * m.next = q;
     */
    public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode m = q.next;
        head.next = null; // 表头置为表尾
        while(m != null){
            q.next = p;
            p = q;
            q = m;
            m = m.next;
        }
        q.next = p;
        m.next = q;
        return head;
    }
}