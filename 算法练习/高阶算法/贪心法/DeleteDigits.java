/** @important
 * 删除数字

 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。

 找到删除 k 个数字之后的最小正整数。

 N <= 240, k <= N

 样例
 给出一个字符串代表的正整数 A 和一个整数 k, 其中 A = 178542, k = 4

 返回一个字符串 "12"
 */
/
public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     * 从左边开始每次找到一个递增区间内一个最大的 删除 知道k个数为止
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if(A.length() <= k){
            return "0";
        }
        for(int i=0; i<k; i++){
            int j = 0;
            while(j < A.length && A.charAt(j) <= A.charAt(j + 1)){
                j++;
            }
            A = A.substring(0, j) + A.substring(j + 1);
        }
        int i = 0;
        while(i < A.length() && A.chatAt(i) == '0') i++;
        return A.substring(i);
    }
}