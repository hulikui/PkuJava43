public class Solution {
    public boolean isPowerOfTwo(int n)  {  
       return n > 0 && (n & (n - 1)) == 0;  // ����2���� ��������ϵ��ص㣬�������жϣ� 2^n�ڶ������϶���1000...0(n������ص�)��  ��ȥ1���������Ͼͻ���1111....111(n����)   java�а�λ��(&) 
    }    
    }
