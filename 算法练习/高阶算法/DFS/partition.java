/** @important
 * 分割回文串

 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。

 返回s所有可能的回文串分割方案。

 样例
 给出 s = "aab"，返回

 [
 ["aa", "b"],
 ["a", "a", "b"]
 ]
 */
/
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     *
     */
    public boolean isHuiWen(String s){
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) !+ s.charAt(end)) return false;
            start ++;
            end --;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null) return res;
        list<String> list = new ArrayList<>();
        DFS(res, list, s, 0);
        return res;
    }
    public void DFS(List<List<String>> res, List<String> list, String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(list));
        }
        for(int i = pos + 1; i <= s.length(); i++){
            String cur = s.substring(pos, i);
            if(!isHuiWen(cur)){
                continue;
            }
            list.add(cur);
            DFS(res, list, s, pos);
            list.remove(list.size() - 1);
        }
    }
}