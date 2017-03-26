/**
 * 背包问题

 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]

 注意事项

 你不可以将物品进行切割。

 样例
 如果有4个物品[2, 3, 5, 7]

 如果背包的大小为11，可以选择[2, 3, 5]装入背包，最多可以装满10的空间。

 如果背包的大小为12，可以选择[2, 3, 7]装入背包，最多可以装满12的空间。

 函数需要返回最多能装满的空间大小。
 */
/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     * dp[i, j] = Math.max(dp[i-1, j - A[i]] + A[i], dp[i-1][j])
     * dp[i, j] 表示 前 i 个物品 装进体积为 j 的背包里 所达到的最大体积
     */
    public int backPack(int m, int[] A) {
        if(A == null || A.length == 0 || m = 0) return 0;
        int len = A.length;
        int[][] dp = new int[len][m + 1];
        for(int i=0; i<len; i++){
            dp[i][0] = 0;//背包体积为0的情况
        }
        for(int j=0; j<m+1; j++){
            if(j > A[0]){
                dp[0][j] = A[0];// 表示前0个物品 包括 第 0 个物品 下标A[0]
            }
        }
        for(int i=1; i<len; i++){
            for(int j=1; j<m+1; j++){
                if(j > A[i]){// i 是从 0开始为了方便 遍历
                    dp[i][j] = Math.max(dp[i-1][j - A[i]] + A[i], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len-1][m];
    }
}