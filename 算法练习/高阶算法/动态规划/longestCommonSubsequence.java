/**
 * 最长公共子序列

 给出两个字符串，找到最长公共子序列(LCS)，返回LCS的长度。

 说明
 最长公共子序列的定义：

 最长公共子序列问题是在一组序列（通常2个）中找到最长公共子序列（注意：不同于子串，LCS不需要是连续的子串）。该问题是典型的计算机科学问题，是文件差异比较程序的基础，在生物信息学中也有所应用。
 https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 样例
 给出"ABCD" 和 "EDCA"，这个LCS是 "A" (或 D或C)，返回1

 给出 "ABCD" 和 "EACB"，这个LCS是"AC"返回 2
 */
/
public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     * dp[i][j] A前i B前j的字符串中LCS
     */
    public int longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = A.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=0; i<=m; i++){
            dp[i][0] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[0][i] = 0;
        }
        int res = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                char a = A.charAt(i);
                char b = B.charAt(j);
                if(a == b){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }
}