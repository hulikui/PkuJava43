/** @important
 * 最小子串覆盖

 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。

 注意事项

 如果在source中没有这样的子串，返回""，如果有多个这样的子串，返回起始位置最小的子串。

 说明
 在答案的子串中的字母在目标字符串中是否需要具有相同的顺序？

 ——不需要。

 样例
 给出source = "ADOBECODEBANC"，target = "ABC" 满足要求的解  "BANC"
 */
/
public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     * 申请 2个数组 安装ASCL编码位置统计数量
     */
    public String minWindow(String source, String target) {
        int[] tgt = new int[255];
        int[] soc = new int[255];
        for(int i=0; i<target.length();i++){
            tgt[target.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int begin = -1;
        int minLen = source.length();
        int found = 0;
        for(int i=0; i<source.length(); i++){
            soc[source.charAt(i)]++;
            //比较同一个字符 的统计数量
            //target里有的soc也有 证明找到一个
            if(soc[source.charAt(i)] <= tgt[source.chatAt(i)]) found++;
            if(found == target.length()){// 说明找到一个子串
                // 从开始结点 一直到 i 去掉重复元素
                while(start < i && soc[source.charAt(i)] > tgt[source.chatAt(i)]){
                    start++;
                    soc[source.charAt(i)]--;
                }
                if(i - start < minLen){
                    begin = start;
                    end = i;
                    minLen = i - start;

                }
            }
            //向前走一步 更新
            soc[source.charAt(i)]--;
            start++;
            found--;
        }
        return begin == -1 ? "" : source.substring(begin, end + 1);
    }
}