/**
 * A + B 问题

 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。

 注意事项

 你不需要从输入流读入数据，只需要根据aplusb的两个参数a和b，计算他们的和并返回就行。

 说明
 a和b都是 32位 整数么？

 是的
 我可以使用位运算符么？

 当然可以
 样例
 如果 a=1 并且 b=2，返回3
 */
/
class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        while(b != 0){
            a = a ^ b;//数
            b = (a & b) << 1; //carry
        }
        return a;
    }
}