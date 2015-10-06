public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> repeatedNums = new HashSet<Integer>();  //������ֻ�ܴ洢���ظ��Ķ���
        while(!repeatedNums.contains(n)){//��ֹ�����ظ�������ͬ�Ľ���������ѭ��  
        repeatedNums.add(n);  
        int sum = 0;  
        while(n != 0){  
            int digit = n % 10;  //��λ������ƽ����
            n /= 10;  
            sum += Math.pow(digit,2);  
        }  
        n = sum;  
        if(sum == 1) return true;  
    }  
    return false;  
    }  
}  