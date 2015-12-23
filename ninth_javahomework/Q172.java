package com.leetcode.homework;

public class Q172 {
	//阶乘运算中能构成10的元素乘积为2*5，10，以及各种开头为2，结尾为0与结尾为5后开头为5结尾为0的组合
    public int trailingZeroes(int n) {
    	int count=0;
        while(n>0){
            n=n/5;
            count+=n;
        }
        return count;
    }
    
    public static void main(String[] args) {
		Q172 q = new Q172();
		System.out.println(q.trailingZeroes(5));
	}
}
