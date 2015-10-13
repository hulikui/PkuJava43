public class Solution {
    public int removeElement(int[] nums, int val) {
    int newLength=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]!=val){
             
             nums[newLength++]=nums[i];
             
          }
         
      }
      return newLength;
    } //开始做的时候可能由于2个循环或者申请了额外数组的原因导致返回结果不正确
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