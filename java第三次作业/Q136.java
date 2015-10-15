package com.leetcode.homework;

public class Q136 {
	//基本思路：对数组进行排序再寻找
	public int singleNumber(int[] nums) {
		int low = 0;
		int high = nums.length-1;
		quickSort(nums,low,high);
		int result = 0;
		for(int i = 0;i<nums.length;i++){
	         if(i+1<nums.length&&nums[i]==nums[i+1]){
	        	 i++;
	        	 continue;
	         }else{
	        	 result = nums[i];
	        	 break;
	         }		
		}
		return result;
    }
	
	public void quickSort(int[] nums,int low,int high){
		if (low < high) {  
            int middle = getMiddle(nums, low, high);  //将list数组进行一分为二  
            quickSort(nums, low, middle - 1);        //对低字表进行递归排序  
            quickSort(nums, middle + 1, high);       //对高字表进行递归排序  
        }
	}
	
	public int getMiddle(int[] list, int low, int high) {  
		int pivot = list[low];
        while (low < high) {
            while (low < high && list[high] >= pivot)
                high--;
            if (low < high)
                list[low++] = list[high];
            while (low < high && list[low] <= pivot)
                low++;
            if (low < high)
                list[high--] = list[low];
        }
        list[low] = pivot;
        return low; 
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,5,3,7,8,8,5,7};
		Q136 q = new Q136();
		System.out.println(q.singleNumber(nums));
	}
}
