public class Solution {
    public String addBinary(String a, String b) {

        int flag = 0;//进位标志
        char[] a1 = a.toCharArray(); // 字符串转换为字符数组
        char[] b1 = b.toCharArray(); // 字符串转换为字符数组
        int aIndex = a.length() - 1;//索引
        int bIndex = b.length() - 1;
        
        String c="";//存结果
        
        while(aIndex >= 0 && bIndex >= 0)//遍历相加
        {
            int num = a1[aIndex] - '0' + (b1[bIndex] - '0') + flag;
            flag = num / 2;
            num %= 2;
            
            c = (char)(num + '0') + c;
            
            aIndex--;
            bIndex--;
        }
        
        while(aIndex >= 0)//a比b长
        {
            int num = a1[aIndex] - '0' + flag;
            flag = num / 2;
            num %= 2;
            
            c = (char)(num + '0') + c;
            
            aIndex--;
        }
        
        while(bIndex >= 0)//b比a长
        {
            int num = b1[bIndex] - '0' + flag;
            flag = num / 2;
            num %= 2;
            
            c = (char)(num + '0') + c;
            
            bIndex--;
        }
        
        if (flag > 0)//遍历相加后，首位出现进位
            c = (char)(flag + '0') + c;
            
        return c;
    }
}