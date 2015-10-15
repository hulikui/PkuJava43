package com.leetcode.homework;

public class Q125 {
    public boolean isPalindrome(String s) {
    	String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
    }
    
    
    public static void main(String[] args) {
		Q125 q = new Q125();
		String s = "A man, a plan, a canal: Panama";
		q.isPalindrome(s);
	}
}
