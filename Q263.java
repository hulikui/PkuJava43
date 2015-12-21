package com.leetcode.homework;

public class Q263 {
    public boolean isUgly(int num) {
        boolean flag = false;
        if(num==0){
        	flag = false;
        }else if(num==1){
        	flag = true;
        }else{
        	int temp = num;
        	while(true){
        		if(temp%2==0){
        			temp = temp/2;
        		}else if(temp%3==0){
        			temp = temp/3;
        		}else if(temp%5 == 0){
        			temp = temp/5;
        		}else if(temp == 1){
                    flag = true;
                    break;    
        		}else{
        			break;
        		}
        	}
        }
        return flag;
    }
    
    public static void main(String[] args) {
    	Q263 q = new Q263();
    	System.out.println(q.isUgly(0));
	}
}
