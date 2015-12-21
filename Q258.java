package com.leetcode.homework;

public class Q258 {
	//int的取值范围：-2147483648 到 2147483647
	//故int的数值加起来最大的数为1999999999 为82，也就是说最多3轮必出结果
    public int addDigits(int num) {
    	int temp = sumDigit(num+"");

        if(temp>20){
        	int s1= sumDigit(temp+"");
        	if(s1>=10){
        		return sumDigit(s1+"");
        	}else{
        		return s1;
        	}
        }else if(temp>=10){
        	return sumDigit(temp+"");
        }else {
        	return temp;
        }
    }
    
    public int sumDigit(String s){
    	int temp = 0 ;
        char[] arr = s.toCharArray();
        
        for(char b:arr){
        	temp+=new Integer(String.valueOf(b));
        }
        return temp = temp ==10?1:temp;
    }
    
    public static void main(String[] args) {
    	Q258 q = new Q258();
    	int ss = q.addDigits(199);
    	System.out.println(ss);
	}
}
