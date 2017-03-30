/**
 * 比较字符串

 比较两个字符串A和B，确定A中是否包含B中所有的字符。字符串A和B中的字符都是 大写字母

 注意事项

 在 A 中出现的 B 字符串里的字符不需要连续或者有序。

 样例
 给出 A = "ABCD" B = "ACD"，返回 true

 给出 A = "ABCD" B = "AABC"， 返回 false
 */
/
public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     * 玩一把消消乐，从B中调出一个在A中发现有直接消掉， B循环完后发现还有剩余元素 返回false
     */
    public boolean compareStrings(String A, String B) {
        if(A.length() < B.length()) return false;
        for(int i = 0; i<B.length(); i++){
            String b = B.substring(i, i+1);
            int index = A.indexOf(b);
            if(index > -1){
                A = A.substring(0, index) + A.substring(index+1);
            }else{
                return false;
            }
        }
        return true;
    }
}