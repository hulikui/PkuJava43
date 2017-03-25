/**
 *  逆波兰表达式求值

 求逆波兰表达式的值。

 在逆波兰表达法中，其有效的运算符号包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰计数表达。

 样例
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
/
public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     * 申请一个栈 遇到数字就入栈 遇到运算符号 就出栈并把运算后的结果再入栈
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        Stack<Integer> s = new Stack<>();
        for(String s: tokens){
            if(s.equals("+")){
                int a = s.pop();
                int b = s.pop();
                s.add(a + b);
            }else if(s.equals("-")){
                int a = s.pop();
                int b = s.pop();
                s.add(a - b);
            }else if(s.equals("*")){
                int a = s.pop();
                int b = s.pop();
                s.add(a * b);
            }else if(s.equals('/')){
                int a = s.pop();
                int b = s.pop();
                s.add(a / b);
            }else{
                s.add(Integer.parseInt(s));
            }
        }
        return s.pop();
    }
}