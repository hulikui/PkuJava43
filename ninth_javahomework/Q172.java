package com.leetcode.homework;

public class Q172 {
	//�׳��������ܹ���10��Ԫ�س˻�Ϊ2*5��10���Լ����ֿ�ͷΪ2����βΪ0���βΪ5��ͷΪ5��βΪ0�����
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
