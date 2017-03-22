/**
 *  复制带随机指针的链表

 给出一个链表，每个节点包含一个额外增加的随机指针可以指向链表中的任何节点或空的节点。

 返回一个深拷贝的链表。
 */
/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     * 首先建立一个map 把 结点当成key, copy的结点（没有结点关系， 单纯的结点）设置为value
     * 第二轮遍历的时候 构造关系 next 以及 random
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> tmp = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            tmp.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            RandomListNode node = tmp.get(cur);
            node.next = tmp.get(cur.next);
            node.random = cur.random;
            cur = cur.next;
        }
        return tmp.get(head);
    }
}