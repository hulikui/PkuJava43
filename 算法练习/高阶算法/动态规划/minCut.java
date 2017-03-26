/** @important
 * 分割回文串 II

 给定一个字符串s，将s分割成一些子串，使每个子串都是回文。

 返回s符合要求的的最少分割次数。

 样例
 比如，给出字符串s = "aab"，

 返回 1， 因为进行一次分割可以将字符串s分割成["aa","b"]这样两个回文子串
 */
/
public class Solution {
    /**
     * @param s a string
     * @return an integer
     * dp[i] 前 i 个字符 最小回文数
     * 判断前 i 字符串
     */
    public int minCut(String s) {
        int[] dp = new int[s.length() + 1];
        for(int i=0; i<=s.length(); i++){
            dp[i] = i;// 最大回文 默认 本身
        }
        for(int i=1; i<=s.length(); i++){
            for(int j=0; j<i; j++){
                if(isPalindrome(s.substring(j, i))){
                    //判断是回文的话立即更新
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()] - 1;//回文数-1 = 分割数
    }
    public boolean isPalindrome(String s){
        for(int i=0; j=s.length()-1; i<j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}