/**
 * 背包问题 II

 给出n个物品的体积A[i]和其价值V[i]，将他们装入一个大小为m的背包，最多能装入的总价值有多大？

 注意事项

 A[i], V[i], n, m均为整数。你不能将物品进行切分。你所挑选的物品总体积需要小于等于给定的m。

 样例
 对于物品体积[2, 3, 5, 7]和对应的价值[1, 5, 2, 4], 假设背包大小为10的话，最大能够装入的价值为9。
 */
/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     * f[i, j] = Math.max(f[i-1][j - A[i]] + V[i], f[i-1][j]);
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int len = A.length;
        int[][] dp = new int[len][m+1];
        for(int i=0; i<len; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<m+1; j++){
            if(j > A[0]){
                dp[0][j] = V[0];// 第 0 个物品 放在体积为 j 的背包中 最大价值
            }
        }
        for(int i=1; i<len; i++){
            for(int j=1; j<m+1; j++){
                if(j > A[i]){
                    dp[i][j] = Math.max(dp[i-1][j] + dp[i-1][j - A[i]] + V[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len-1][m];
    }
}