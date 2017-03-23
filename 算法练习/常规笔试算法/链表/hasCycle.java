/**
 * 带环链表

 给定一个链表，判断它是否有环。

 您在真实的面试中是否遇到过这个题？ Yes
 样例
 给出 -21->10->4->5, tail connects to node index 1，返回 true
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
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     * 很常见的题 设置2个指针 一个走2步 一个走一步 走2步的肯定能追赶上慢的
     */
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        LstNode fast = head;
        while(slow != null || fast != null){
            slow = slow.next;
            if(slow == null) break;
            fast = fast.next.next;
            if(fast == null) break;
            if(slow.val == fast.val) return true;
        }
        return false
    }
}