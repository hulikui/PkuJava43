public class Solution {
    public String addBinary(String a, String b) {

        int flag = 0;//��λ��־
        char[] a1 = a.toCharArray(); // �ַ���ת��Ϊ�ַ�����
        char[] b1 = b.toCharArray(); // �ַ���ת��Ϊ�ַ�����
        int aIndex = a.length() - 1;//����
        int bIndex = b.length() - 1;
        
        String c="";//����
        
        while(aIndex >= 0 && bIndex >= 0)//�������
        {
            int num = a1[aIndex] - '0' + (b1[bIndex] - '0') + flag;
            flag = num / 2;
            num %= 2;
            
            c = (char)(num + '0') + c;
            
            aIndex--;
            bIndex--;
        }
        
        while(aIndex >= 0)//a��b��
        {
            int num = a1[aIndex] - '0' + flag;
            flag = num / 2;
            num %= 2;
            
            c = (char)(num + '0') + c;
            
            aIndex--;
        }
        
        while(bIndex >= 0)//b��a��
        {
            int num = b1[bIndex] - '0' + flag;
            flag = num / 2;
            num %= 2;
            
            c = (char)(num + '0') + c;
            
            bIndex--;
        }
        
        if (flag > 0)//������Ӻ���λ���ֽ�λ
            c = (char)(flag + '0') + c;
            
        return c;
    }
}