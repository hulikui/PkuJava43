/**
 * 二进制求和

 给定两个二进制字符串，返回他们的和（用二进制表示）。

 样例
 a = 11

 b = 1

 返回 100
 */
/
public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        String res = "";
        int carry = 0;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        while(aIndex >= 0 || bIndex >= 0){
            if(aIndex >= 0){
                carry += Integer.parseInt(s.substring(aIndex, aIndex + 1));
                aIndex--;
            }
            if(bIndex >= 0){
                carry += Integer.parseInt(s.substring(bIndex, bIndex + 1));
                bIndex--;
            }
            if(carry == 0){
                res = "0" + res;
            }else if(carry == 1){
                res = "1" + res;
            }else if(carry == 2){
                res = "0" + res;
                carry = 1;
            }else if(carry == 3){
                res = "1" + res;
                carry = 1;
            }

        }
        if(carry == 1){
            res = "1" + res;
        }
        return res;
    }
}
