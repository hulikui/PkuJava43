/** @important
 *  回文链表

 设计一种方式检查一个链表是否为回文链表。

 1->2->1 就是一个回文链表。
 */
/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     * 回文特征 设置一个栈 统计前半部分入栈 然后对比后半部分
     * 申请快和慢各一个指针， 快的走2步 慢的一步， 快的遍历完 慢的刚好在中点附近（奇数和偶数长度不确定）
     * 链表长度 偶数 和 奇数 需要判断 （三到四个结点模拟一下就知道）
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> tmp = new Stack<>();
        ListNode slow = new ListNode<>();
        ListNode fast = new ListNode<>();
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        // 修正奇偶长度 开始结点指向
        if(fast.next != null) slow = slow.next;// 偶数
        while(slow != null){
            if(slow.val != tmp.pop().val){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}