/** @important
 * 电话号码的字母组合

 给一个不包含01的数字字符串，每个数字代表一个字母，请返回其所有可能的字母组合。

 下图的手机按键图，就表示了每个数字可以代表的字母。

 Cellphone

 注意事项

 以上的答案是按照词典编撰顺序进行输出的，不过，在做本题时，你也可以任意选择你喜欢的输出顺序。

 样例
 给定 "23"

 返回 ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 */
/
public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        String[] dic = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        String temp = "";
        ArrayList<Integer> res = new ArrayList<>();
        DFS(res, digits, dic, temp);
        return res;
    }
    public void DFS(ArrayList<String> res, String digits, String[] dic, String temp){
        if(digits.length() == 0){
            res.add(temp);
            return;
        }
        String s = dic[Integer.parseInt(digits.substring(0, 1))];
        for(int i=0; i<s.length(); i++){
            DFS(res, digits.substring(1), dic, temp + s.substring(i, i+1));
        }
    }
}