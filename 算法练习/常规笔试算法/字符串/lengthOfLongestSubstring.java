/**
 * 最长无重复字符的子串

 给定一个字符串，请找出其中无重复字符的最长子字符串。

 样例
 例如，在"abcabcbb"中，其无重复字符的最长子字符串是"abc"，其长度为 3。

 对于，"bbbbb"，其无重复字符的最长子字符串为"b"，长度为1。
 */
/
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     * map遍历 遇到 map 中没有的直接添加
     * 遇到map中含有的 立即 更新 max 以及修正遍历的当前索引
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i, i+1);
            if(map.containsKey(cur)){
                max = Math.max(map.size(), max);
                map.clear();
                i = map.get(cur);
            }else{
                map.put(cur, i);
            }
        }
        max = Math.max(map.size(), max);
        return max;
    }
}