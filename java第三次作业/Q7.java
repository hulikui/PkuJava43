package com.leetcode.homework;

public class Q7 {
    public int reverse(int x) {
    	 char[] arr = (String.valueOf(x)).toCharArray();
    	 int startIndex = arr[0]=='-'?1:0;
    	 int endIndex = arr.length-1;
    	
    	 while(startIndex<endIndex){
    		 char temp = arr[startIndex];
    		 arr[startIndex] = arr[endIndex];
    		 arr[endIndex] = temp;
    		 
    		 startIndex++;
    		 endIndex--;
    	 }
    	Long lNum = new Long(String.valueOf(arr));
    	if(lNum>2147483647||lNum<-2147483647)
    		return 0;
		return lNum.intValue();
    }
    
    public static void main(String[] args) {
		int x = 964632435;
		Q7 q = new Q7();
		System.out.println(q.reverse(x));
	}
}
