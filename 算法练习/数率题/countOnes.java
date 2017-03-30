/**
 * 二进制中有多少个1

 计算在一个 32 位的整数的二进制表式中有多少个 1.

 样例
 给定 32 (100000)，返回 1

 给定 5 (101)，返回 2

 给定 1023 (111111111)，返回 9
 */
/
public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        if(num == 0) return 0;
        else if(num > 0){
            return getOneNum(num);
        }else{
            int a = -num;
            //负数 补码存储， 最后一位为 1 补码+1 = 实际 多1
            return a % 2 > 0 ? 32 - getOneNum(num) + 1 : 32 - getOneNum(num);
        }
    }
    public int getOneNum(int num){
        num = Math.abs(num);
        int count = 0;
        while(num != 0){
            if(num % 2 == 1) count++;
            num = num / 2;
        }
        return num >= 2 ? count + 1 : count;
    }
}