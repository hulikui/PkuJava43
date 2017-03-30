/** @important
 * 报数

 报数指的是，按照其中的整数的顺序进行报数，然后得到下一个数。如下所示：

 1, 11, 21, 1211, 111221, ...

 1 读作 "one 1" -> 11.

 11 读作 "two 1s" -> 21.

 21 读作 "one 2, then one 1" -> 1211.

 给定一个整数 n, 返回 第 n 个顺序。

 注意事项

 整数的顺序将表示为一个字符串。

 样例
 给定 n = 5, 返回 "111221".
 */
/
public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    // 计算出 相邻相同元素的个数
    // String.toCharArray()
    public String countAndSay(int n) {
        String oldString = "1";
        while(--n > 0){
            String a = "";
            char[] oldChars = oldString.toCharArray();
            for(int i=0; i<oldChars.length; i++){
                int count = 0;
                while((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]){
                    count ++;
                }
                a += count + String.valueOf(oldChars[i]);
            }
            oldString = a;
        }
        return oldString;
    }
}