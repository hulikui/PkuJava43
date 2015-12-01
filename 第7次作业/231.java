public class Solution {
    public boolean isPowerOfTwo(int n)  {  
       return n > 0 && (n & (n - 1)) == 0;  // 利用2的幂 其二进制上的特点，来进行判断； 2^n在二进制上都是1000...0(n个零的特点)；  减去1，二进制上就会变成1111....111(n个零)   java中按位与(&) 
    }    
    }
