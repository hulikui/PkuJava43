/** @important
 *  打劫房屋

 假设你是一个专业的窃贼，准备沿着一条街打劫房屋。每个房子都存放着特定金额的钱。你面临的唯一约束条件是：相邻的房子装着相互联系的防盗系统，且 当相邻的两个房子同一天被打劫时，该系统会自动报警。

 给定一个非负整数列表，表示每个房子中存放的钱， 算一算，如果今晚去打劫，你最多可以得到多少钱 在不触动报警装置的情况下。

 样例
 给定 [3, 8, 4], 返回 8.
 *
 */
/
public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     * dp[i]表示前 i 个房屋达到最高的收益 包含 i
     */
    public long houseRobber(int[] A) {
        if(A.length == 0) return 0;
        if(A.length == 1) return (long) A[0];
        int[] dp = new int[A.length];
        dp[0] = (long)A[0];
        dp[1] = (long)Math.max(A[0], A[1]);
        for(int i=2; i<A.length; i++){
            // 要么选择A[i] 要么不选择A[i]即 dp[i-1]
            dp[i] = Math.max(dp[i-2] + (long)A[i], dp[i-1]);
        }
        return dp[A.length-1];
    }
}