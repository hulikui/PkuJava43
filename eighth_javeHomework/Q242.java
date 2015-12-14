package com.leetcode.homework;

import java.util.Arrays;

public class Q242 {
    public boolean isAnagram(String s, String t) {
    	char[] chars_a = s.toCharArray();
    	Arrays.sort(chars_a);
    	char[] chars_b = t.toCharArray();
    	Arrays.sort(chars_b);
    	return new String(chars_b).equals(new String(chars_a));
    }
    
    public static void main(String[] args) {
		Q242 q = new Q242();
		System.out.println(q.isAnagram("anagram", "nagaram"));
	}
}
