/**
 *  两个链表的交叉

 请写一个程序，找到两个单链表最开始的交叉节点。

 注意事项

 如果两个链表没有交叉，返回null。
 在返回结果后，两个链表仍须保持原有的结构。
 可假定整个链表结构中没有循环。
 下列两个链表：

 A:          a1 → a2
                    ↘
                        c1 → c2 → c3
                    ↗
 B:     b1 → b2 → b3
 在节点 c1 开始交叉。
 */
/
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     * 遍历两个链表 统计结点数目为：numA, numB;
     * numA - numB = diff 谁长就移动结点 diff 个单位
     * 然后再分别比较 结点的值 相等则返回该结点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA;
        ListNode pB = headB;
        int numA = 0;
        int numB = 0;
        while(pA != null){
            numA++;
            pA = pA.next;
        }
        while(pB != null){
            numB++;
            pB = pB.next;
        }
        pA = headA;
        pB = headB;
        if(numA > numB){
            int diff = numA - numB;
            while(diff > 0){
                pA = pA.next;
                diff--;
            }
        }else{
            int diff = numB - numA;
            while(diff > 0){
                pB = pB.next;
                diff--;
            }
        }
        while(pA != null && pB != null){
            if(pA.val == pB.val){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}