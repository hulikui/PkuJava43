/** @important
 * 完美平方

 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n。你需要让平方数的个数最少。

 样例
 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4。
 给出 n = 13, 返回 2 因为 13 = 4 + 9。
 */
/
public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     * dp[i + j*j] 表示 n = i + j*j 最少的平方数
     * i*i <= n 的结点 是一个特殊点 初始化次数 为 1次  其他均初始化为最大数 方便比较
     */
    public int numSquares(int n) {
        int dp = new dp[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0; i*i<=n; i++){
            dp[i*i] = 1;
        }
        for(int i=1; i<=n; i++){// 第一个数 i
            for(int j=1; i + j*j <=n; j++){//第二个数 j * j
                dp[i + j*j] = Math.min(dp[i] + 1, dp[i + j*j]);
            }
        }
        return dp[n];
    }
}