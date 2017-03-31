/**
 * 尾部的零

 设计一个算法，计算出n阶乘中尾部零的个数

 您在真实的面试中是否遇到过这个题？ Yes
 样例
 11! = 39916800，因此应该返回 2
 */
/
class Solution {
    /**
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     *1. 获取计算阶乘的这个数, 比如(101!则取101)
     2. 将这个数除以5，只取整数部分（以下相同）
     3. 除以52(25)
     4. 除以53(125)
     5. 继续除以5的更高次幂，直到结果小于1。
     6. 将以上所有的除法结果相加，就是尾零数的个数
     * /
     */
    public long trailingZeros(long n) {
        long res = 0;
        while(n > 0){
            res += (n/5);
            n = n/5;
        }
        return res;
    }
}