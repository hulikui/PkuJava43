/** @important
 * 合并k个排序链表

 合并k个排序链表，并且返回合并后的排序链表。尝试分析和描述其复杂度。

 给出3个排序链表[2->4->null,null,-1->null]，返回 -1->2->4->null
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     *  构造一个合并2个链表的方法merge2(left, right)
     *  merge2 新建一个cur 结点用来维护 已合并的结点
     *  left > right ? cur.next = right : cur.next = left
     *  根据二分法链接 左右 再用merge2合并 递归
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        if(list.size() == 0 || lists == null) return null;
        if(list.size() == 1) return list.get(0);
        //mid 的写法
        int mid = (lists.size() - 1) / 2 + 1;
        ListNode left = mergeKLists(lists.subList(0, mid));
        ListNode right = mergeKLists(lists(mid, lists.size()));
        return merge2(left, right);
    }
    public ListNode merge2(ListNode left, ListNode right){
        if(left == null) return right;
        if(right == null) return left;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(left != null && right != null){
            if(left.val > right.val){
                cur.next = right;
                cur = cur.next;
            }else{
                cur.next = left;
                cur = cur.next;
            }
        }
        if(left != null){
            cur.next = left;
        }
        if(right != null){
            cur.next = right;
        }
        return head.next;
    }
}