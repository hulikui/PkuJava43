/**
 *  翻转链表 II

 翻转链表中第m个节点到第n个节点的部分

 注意事项

 m，n满足1 ≤ m ≤ n ≤ 链表长度
 样例
 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     * 遍历到 要翻转的区间的前一个结点 pre , 当前结点 cur 以及 下一个结点 q
     * 以次 翻转 cur q 直到翻转所有项目
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head == null || head.next == null) return head;
        ListNode root = new ListNode(-1);
        ListNode pre = root;
        root.next = head;
        for(int i = 1; i < m && pre != null; i++){//注意达到指定位置需要的边界
            pre = pre.next;
        }
        if(pre != null){
            ListNode cur = pre.next;
            ListNode q;
            n = n - m + 1;
            for(int i = 1; i < n && cur.next != null; i++){
                r = cur.next;// 当前结点的后一个结点
                cur.next = r.next;
                r.next = cur;
                pre.next = r;
            }
            //修正首结点
            head = root.next;
        }
        return head;
    }
}