package com.leetcode.homework;

import java.util.Arrays;

public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<2)
        	return false;
        int preNum = nums[0];
        for(int i=1;i<nums.length;i++){
        	int curNum = nums[i];
        	if(preNum==curNum)
        		return true;
        	preNum = curNum;
        }
        return false;
    }
    
    public static void main(String[] args) {
		Q217 q = new Q217();
		int[] nums = {1,2};
		System.out.println(q.containsDuplicate(nums));
		
	}
}
