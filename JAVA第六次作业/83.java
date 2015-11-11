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
        ListNode ptr2 = head.next;//����ָ��
        
        while(ptr2!=null){
            if(ptr1.val == ptr2.val){//�鵽�ظ���Ԫ�أ�������ָ�롱
                ptr2 = ptr2.next;
                if(ptr2==null)//����Ƿ���β
                    ptr1.next = null;
            }else{//û���ظ�Ԫ�أ������ƶ�P1��P2��ָ�롱
              ptr1.next = ptr2;//���ȵ���P1���ٵ���P2
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }

        return head;
    }
}