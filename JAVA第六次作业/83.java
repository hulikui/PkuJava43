/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;//查重指针
        
        while(ptr2!=null){
            if(ptr1.val == ptr2.val){//查到重复的元素，更换“指针”
                ptr2 = ptr2.next;
                if(ptr2==null)//检测是否到链尾
                    ptr1.next = null;
            }else{//没有重复元素，继续移动P1和P2“指针”
              ptr1.next = ptr2;//首先调整P1，再调整P2
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        return head;
    }
}