public class Solution {
    public int myAtoi(String str) {
        str=str.trim();//ȥ�ո�
        int sl = str.length();
        int index=0;
        char tempc;            //��ȡ�ַ�
        boolean flag = false;  //������־
        int firstI=-1;
        long re=0;
        
        if(sl<=0)
            return 0;
     
         
        //1. �жϵ�һ���ǿ��ַ��Ƿ�Ϸ�
        tempc = str.charAt(index);
        //1.1 ����+-����ֵ����У������򷵻�0
        if(tempc=='-'||tempc=='+'||(tempc<='9'&&tempc>='0'))
        {   
            //1.2 ������ֵ�������ж�
            if((tempc<='9'&&tempc>='0')) {                            
            }else                        //1.3 ����+-�ţ����жϽ��������Ƿ�Ϊ��ֵ
            {
              if(tempc=='-') flag = true;//1.3.1 ����-�ţ������ñ�־λ
              
              index++;                   
              //1.4 ����+-�ţ����ж���һλ�ǲ�����ֵ������Ϸ��������򷵻�0
              tempc = str.charAt(index);
              if((tempc<='9'&&tempc>='0'))
              {}else{
                   return 0;
               }
            }
            
        }else    //2.1 ����+-����ֵ����У�����������
        { 
            return 0;
        }

        //3. ��ʼɨ����Ч����
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
