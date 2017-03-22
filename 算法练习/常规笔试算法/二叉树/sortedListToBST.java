/**
 *  排序列表转换为二分查找树

 给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树

 2
 1->2->3  =>   / \
 1   3
 标签
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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     * 该题核心在于转换为二分查找数的构造定义，排序 中点 左小又大
     */
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        if(head == null) return res;
        while(head != null){
            res.add(head.val);
            head = head.next;
        }
        return createTree(res, 0, res.size() - 1);
    }
    public TreeNode createTree(ArrayList<Integer> res, int l, int r){
        if(l > r) return null;
        int mid = (l + r) / 2;
        TreeNode node = new TreeNode(res.get(mid));
        node.left = createTree(res, l, mid - 1);
        node.right = createTree(res, mid + 1, r);
        return node;
    }
}