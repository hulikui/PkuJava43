/** @important
 *  重排链表

 给定一个单链表L: L0→L1→…→Ln-1→Ln,

 重新排列后为：L0→Ln→L1→Ln-1→L2→Ln-2→…

 必须在不改变节点值的情况下进行原地操作。

 样例
 给出链表 1->2->3->4->null，重新排列后为1->4->2->3->null。
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
     * @return: void
     * 申请 四个结点指针 第一个headNode和第二个headNextNode  最后一个lastNode 和 倒数第二个lastPreNode
     * 每次递归交换
     * lastPreNode.next = null;//保证变成下一次的尾结点
     * headNode.next = lastNode;// 把 尾结点 插入头结点后面
     * 进入递归函数fun(headNextNode) // headNextNode 作为新的头结点
     * lastNode.next = headNextNode; // 修正next
     */
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode lastNode = head.next;
        ListNode lastPreNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            lastPreNode = lastPreNode.next;
        }
        ListNode headNextNode = head.next;
        // 交换
        head.next = lastNode;
        lastPreNode.next == null;// 置为尾部结点
        reorderList(headNextNode);
        lastNode.next = headNextNode;
    }
}