/** @important
 * 子树

 有两个不同大小的二进制树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。

 注意事项

 若 T1 中存在从节点 n 开始的子树与 T2 相同，我们称 T2 是 T1 的子树。也就是说，如果在 T1 节点 n 处将树砍断，砍断的部分将与 T2 完全相同。

 您在真实的面试中是否遇到过这个题？ Yes
 样例
 下面的例子中 T2 是 T1 的子树：

 1                3
 / \              /
 T1 = 2   3      T2 =  4
 /
 4
 下面的例子中 T2 不是 T1 的子树：

 1               3
 / \               \
 T1 = 2   3       T2 =    4
 /
 4
 */
/
/**
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
 * @param T1, T2: The roots of binary tree.
 * @return: True if T2 is a subtree of T1, or false.
 * 递归判断 当前点是否相等 如果相等继续递归比较是否接下来各个结点都相等
 * 如果不相等 证明 T2 在 T1的 子树上
 */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        // 找到 T2在 T1上的root结点
        boolean res = false;
        if(T1 == null) return false;
        if(T2 == null) return true;
        if(T1.val == T2.val){
            res = isSame(T1, T2);
        }
        if(!res) res = isSubtree(T1.left, T2);
        if(!res) res = isSubtree(T1.right, T2);
        return res;
    }
    public boolean isSame(TreeNode T1, TreeNode T2){
        if(T1 != null && T2 != null && T1.val == T2.val){
            return isSame(T1.left, T2.left) && isSame(T2.left, T2.right);
        }
        if(T1 == null && T2 == null) return true;
        return false;
    }
}