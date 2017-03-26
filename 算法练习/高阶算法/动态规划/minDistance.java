/** @important
 * 编辑距离

 给出两个单词word1和word2，计算出将word1 转换为word2的最少操作次数。

 你总共三种操作方法：

 插入一个字符
 删除一个字符
 替换一个字符

 样例
 给出 work1="mart" 和 work2="karma"

 返回 3
 */
/
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     * dp[i][j] 表示 word1 从第一个字符到第 i 个 变到 word2 前 j 个字符 所需要最少操作次数
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 第0 个字符不存在即 为0， 从第1个到len
        for(int i=1; i<=m; i++){
            dp[i][0] = i;
        }
        for(int i=1; i<=n; i++){
            dp[0][i] = i;
        }
        for(int i=1; i<=m; i++){
            char l = word1.charAt(i);
            for(int j=1; i<=n; j++){
                char r = word2.charAt(j);
                if(l == r){//两个字符相等就不用增加操作
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}