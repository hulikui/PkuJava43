/** @important
 * 跳跃游戏
 给出一个非负整数数组，你最初定位在数组的第一个位置。　　　

 数组中的每个元素代表你在那个位置可以跳跃的最大长度。　　　　

 判断你是否能到达数组的最后一个位置。

 注意事项

 这个问题有两个方法，一个是贪心和 动态规划。

 贪心方法时间复杂度为O（N）。

 动态规划方法的时间复杂度为为O（n^2）。

 我们手动设置小型数据集，使大家阔以通过测试的两种方式。这仅仅是为了让大家学会如何使用动态规划的方式解决此问题。如果您用动态规划的方式完成它，你可以尝试贪心法，以使其再次通过一次。

 您在真实的面试中是否遇到过这个题？ Yes
 样例
 A = [2,3,1,1,4]，返回 true.

 A = [3,2,1,0,4]，返回 false.
 */
/
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     * 贪心法 下标 index + 当前可以的迈进的步数 大于 数组的长度 证明就可以达到终点
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        int max = 0;
        int cur = 0;
        //当前步数 不能超过 允许的最大步数
        while(cur <= max){
            max = Math.max(max, cur + A[cur]);
            cur++;
            // 最大步数能够到达末尾
            if(max >= A.length - 1){
                return true;
            }
        }
        return false;
    }
}