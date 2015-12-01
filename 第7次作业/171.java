public class Solution {
    public int titleToNumber(String s) {
     int ret = 0;
        for(int i = 0; i < s.length(); i ++)
            ret = ret*26 + (s.charAt(i) -'A'+1);//每多一个A +26,个位数代表权值
        return ret;   
    }
}