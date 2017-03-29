/** @important
 * 生成括号

 给定 n 对括号，请写一个函数以将其生成新的括号组合，并返回所有组合结果。

 样例
 给定 n = 3, 可生成的组合如下:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
/
public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     * L代表还剩下的(的数量，R同理； 左括号剩余数量一定永远 <= 右括号，因为先放。
     * 如果出现了 R < L 的情况，必定是先放了一个右括号，立刻 return
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        helper(res, n, n, "");
        return res;
    }
    public void helper(ArrayList<String> res, int leftR, int rightR, String temp){
        if(leftR > rightR) return;
        if(leftR == 0 && rightR == 0){
            res.add(temp);
        }
        if(leftR > 0) helper(res, leftR-1, rightR, temp + "(");
        if(rightR > 0) helper(res, leftR, rightR - 1, temp + ")");
    }
}