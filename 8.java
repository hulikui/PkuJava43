public class Solution {
    public int myAtoi(String str) {
        str=str.trim();//去空格
        int sl = str.length();
        int index=0;
        char tempc;            //获取字符
        boolean flag = false;  //负数标志
        int firstI=-1;
        long re=0;
        
        if(sl<=0)
            return 0;
     
         
        //1. 判断第一个非空字符是否合法
        tempc = str.charAt(index);
        //1.1 若是+-或数值则进行，否则则返回0
        if(tempc=='-'||tempc=='+'||(tempc<='9'&&tempc>='0'))
        {   
            //1.2 若是数值则跳出判断
            if((tempc<='9'&&tempc>='0')) {                            
            }else                        //1.3 若是+-号，则判断接下来的是否为数值
            {
              if(tempc=='-') flag = true;//1.3.1 若是-号，则设置标志位
              
              index++;                   
              //1.4 若是+-号，则判断下一位是不是数值，是则合法，不是则返回0
              tempc = str.charAt(index);
              if((tempc<='9'&&tempc>='0'))
              {}else{
                   return 0;
               }
            }
            
        }else    //2.1 若是+-或数值则进行，否则则跳出
        { 
            return 0;
        }

        //3. 开始扫描有效数字
        while(index<sl)
         {
            tempc = str.charAt(index);
            if(tempc<='9'&&tempc>='0')
            {
             re = re*10 + (str.charAt(index)-'0');
             if(re>=Integer.MAX_VALUE||re<=Integer.MIN_VALUE)
                break;
            }else 
            {
                break;
            }
            index++;
         }
        
        if(flag==true) 
        { re=-re;
          re = re<Integer.MIN_VALUE?Integer.MIN_VALUE:re;
        }else
        {
          re = re>Integer.MAX_VALUE?Integer.MAX_VALUE:re;
        }
        return (int)re;
    }
}
