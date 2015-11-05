public class Solution {
    public int majorityElement(int[] num) {
        if(num.length==1){
            return num[0];
        }
 
        Arrays.sort(num);//��������Ȼ�����Ԫ�أ���ͬԪ�س���n/2�����أ�û�м�������
 
        int prev=num[0];
        int count=1;
        for(int i=1; i<num.length; i++){
            if(num[i] == prev){
                count++;
                if(count > num.length/2) return num[i];
            }else{
                count=1;
                prev = num[i];
            }
        }
 
        return 0;
    }
}