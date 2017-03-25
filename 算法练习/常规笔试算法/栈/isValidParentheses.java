/**
 * 有效的括号序列

 给定一个字符串所表示的括号序列，包含以下字符： '(', ')', '{', '}', '[' and ']'， 判定是否是有效的括号序列。

 样例
 括号必须依照 "()" 顺序表示， "()[]{}" 是有效的括号，但 "([)]"则是无效的括号
 */
/
public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     * 申请一个数组或者栈 遇到 括号左边的就加入 遇到括号右边的就
     */
    public boolean isValidParentheses(String s) {
        if(s.length() == 0 || s.charAt(0) == "}" || s.charAt(0) == "]" || s.charAt(0) == ")") return false;
        char[] temp = new char[s.length()];
        int index = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '{' || c == '[' || c == '('){
                temp[index++] = c;
            }else if(c == '}'){
                int p = index - 1;//是否已经是栈底
                if(p < 0){// 说明 右边括号多
                    return false;
                }
                if(temp[p] == '{'){//括号对应 模拟出栈
                    index --;
                }else{  //假如括号类型不匹配直接退出
                    return false;
                }
            } else if(c == ']'){
                int p = index - 1;//是否已经是栈底
                if(p < 0){// 说明 右边括号多
                    return false;
                }
                if(temp[p] == '['){//括号对应 模拟出栈
                    index --;
                }else{  //假如括号类型不匹配直接退出
                    return false;
                }
            }else if(c == ')'){
                int p = index - 1;//是否已经是栈底
                if(p < 0){// 说明 右边括号多
                    return false;
                }
                if(temp[p] == '('){//括号对应 模拟出栈
                    index --;
                }else{  //假如括号类型不匹配直接退出
                    return false;
                }
            }
        }
        if(index > 0) return false;//说明有多余括号
        return true;
    }
}