/** @important
 * 恢复IP地址

 给一个由数字组成的字符串。求出其可能恢复为的所有IP地址。

 样例
 给出字符串 "25525511135"，所有可能的IP地址为：

 [
 "255.255.11.135",
 "255.255.111.35"
 ]
 （顺序无关紧要）
 */
/
public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     * size 结束条件是 小数点 == 3
     */
    public boolean isValid(String s){
        if(s.charAt(0) == '0') return s.equals("0");//以0为开头
        int num = Integer.parseInt(s);
        return num >=0 && num <= 255;

    }
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        if(s.length() > 12 || s.length() <  4) return res;
        DFS(res, "", s, 0);
        return res;
    }
    public void DFS(ArrayList<String> res, String temp, String s, int size){
        if(size == 3 && isValid(s)){
            res.add(temp + s);
            return;
        }
        for(int i=1; i<s.length() && i < 4; i++){
            String cur = s.substring(0, i);
            if(isValid(cur)){
                DFS(res, temp + cur + ".", s.substring(i), size+1);
            }
        }
    }

}