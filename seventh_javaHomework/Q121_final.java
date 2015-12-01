package com.leetcode.homework;

public class Q121_final {
	//从头遍历，出现小值代替
	 public int maxProfit(int[] prices) {
		 if(prices.length<1) return 0;
		 int min = prices[0];
		 int max = 0;
		 for(int i =1;i<prices.length;i++){
			 max = prices[i]-min>max?prices[i]-min:max;
			 min = prices[i]<min?prices[i]:min;
			 
		 }
		 return max;
	 }
}
