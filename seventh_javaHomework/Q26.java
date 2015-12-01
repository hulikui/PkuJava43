package com.leetcode.homework;

public class Q26 {
    public int removeDuplicates(int[] nums) {
    	int length = nums.length;
    	
    	if(length<1)  return length;
    	int preNum = nums[0];
    	int removeLen = 0;
        for(int i=1;i<nums.length;i++){
        	int curNum = nums[i];
        	if(preNum == curNum){
        		removeLen++;
        	}else{
        		nums[i-removeLen]=nums[i];
        	}
        	preNum = nums[i];
        }
        return length-removeLen;
    }
    
    public static void main(String[] args) {
		Q26 q = new Q26();
		int[] nums ={1,1,1,2,2};
		System.out.println(q.removeDuplicates(nums));
	}
}
