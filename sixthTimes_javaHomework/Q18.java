package com.leetcode.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q18 {
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums==null||nums.length==0)
    		return result;
    	Arrays.sort(nums);

        for (int a = 0; a < nums.length - 3; a++) {
            if (a!= 0 && nums[a] == nums[a - 1])  continue;

            for (int d = nums.length - 1; d >= a + 3; d--) {
                if (d != nums.length - 1  && nums[d] == nums[d + 1]) continue;

                int absence = target - nums[a] - nums[d];
                int b = a + 1;
                int c = d - 1;
                while (b < c) {
                    if ( (nums[c] + nums[b]) > absence){
                        while (c > b  && c > a && nums[c] == nums[c - 1]) {
                            c--;
                        }
                        c--;
                    }else if ( (nums[b] + nums[c]) < absence){
                        while (b < c && b < d && nums[b] == nums[b + 1]) {
                            b++;
                        }
                        b++;
                    }else{
                        List<Integer> inner = new LinkedList<Integer>();
                        inner.add(nums[a]);
                        inner.add(nums[b]);
                        inner.add(nums[c]);
                        inner.add(nums[d]);
                        result.add(inner);
                        while (c > b  && c > a && nums[c] == nums[c - 1]) {
                            c--;
                        }
                        c--;
                        while (b < c && b < d && nums[b] == nums[b + 1]) {
                            b++;
                        }
                        b++;
                    }
                }
            }
        }
        return result;
	}            
}           
            
