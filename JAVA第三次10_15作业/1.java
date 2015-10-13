public class Solution {
    public int[] twoSum(int[] nums, int target) {
       // if(nums.length<=1) return 0;
       
        int[] TwoNum=new int[2];
        for(int i=0;i<nums.length;i++){//双层循环查目标和的俩个数
            for(int j=i+1;j<nums.length;j++){
                
                if(nums[i]+nums[j]==target){
                  
                    TwoNum[0]=i+1;   //修正下标
                    TwoNum[1]=j+1; 
                    break;
                }
             
            
            }
            
        }

        
        return TwoNum;
        
    }
}