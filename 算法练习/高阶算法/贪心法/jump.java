/** @important
 * 跳跃游戏 II

 给出一个非负整数数组，你最初定位在数组的第一个位置。

 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　

 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

 样例
 给出数组A = [2,3,1,1,4]，最少到达数组最后一个位置的跳跃次数是2(从数组下标0跳一步到数组下标1，然后跳3步到数组的最后一个位置，一共跳跃2次)
 */
/
public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     * maxR 当前能到的最大步数
     * 遍历所有节点 cur 表示所有当前多走的步数 if cur == maxR 证明刚好达到下一次跳跃 更新cur = maxR
     */
    public int jump(int[] A) {
        int maxR = 0;
        int cur = 0;
        int step = 0;
        for(int i=0; i<A.length; i++){
            maxR = Math.max(maxR, A[i] + i);
            if(i == maxR){
                cur = maxR;
                step++;
                if(cur >= A.length - 1){
                    return step;
                }
            }
        }
        return step;
    }
}
