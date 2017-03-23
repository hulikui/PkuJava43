/** @important
 * 删除排序链表中的重复数字 II

 给定一个排序链表，删除所有重复的元素只留下原链表中没有重复的元素。

 样例
 给出 1->2->3->3->4->4->5->null，返回 1->2->5->null

 给出 1->1->1->2->3->null，返回 2->3->null
 */
/
/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     * 申请2个结点 pre 前一个结点 以便 在删除相同结点丢失链表
     * cur 对比 下个结点 的值 如果值相等直接 cur = cur.next;
     * 对比的过程细节就是一直保证 cur.next !=null && cur.next.val = cur.val
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
            }else{
                // 修正前面一个结点, 维持关系
                pre.next = cur;
                pre = pre.next;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
