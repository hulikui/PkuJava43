public class Solution {
    public int removeElement(int[] nums, int val) {
    int newLength=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]!=val){
             
             nums[newLength++]=nums[i];
             
          }
         
      }
      return newLength;
    } //��ʼ����ʱ���������2��ѭ�����������˶��������ԭ���·��ؽ������ȷ
     /*int newLength=nums.length;
      for(int i=0;i<nums.length;i++){
          if(nums[i]==val){
              newLength--;
          }
      }
      int j=0,m=0;
      int[] newNums=new int[newLength];
      for(j=0;j<nums.length;j++){
          if(nums[j]!=val){
             
             newNums[m++]=nums[j];
             
          }
          else{
              j++;
          }
      }
      return newLength;
    }*/
}