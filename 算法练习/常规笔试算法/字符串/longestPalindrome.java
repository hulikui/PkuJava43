/** @important
 * 最长回文子串

 给出一个字符串（假设长度最长为1000），求出它的最长回文子串，你可以假定只有一个满足条件的最长回文串。

 样例
 给出字符串 "abcdzdcab"，它的最长回文子串为 "cdzdc"。
 */
/
public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String res = "";
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            getPalindromeString(s, i, 0);// 偶数
            getPalindromeString(s, i, 1);// 奇数长度的遍历
        }
        return res;
    }
    //两边扩散寻找
    public void getPalindromeString(String s, int index, int offset){
        int start = index;
        int end = index + offset;
        while(end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        String cur = s.substring(start + 1, end);
        res = res.length() < cur.length() ? cur : res;
    }
}