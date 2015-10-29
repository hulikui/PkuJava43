public class Solution {
   List<List<Integer>> listAll = new ArrayList<List<Integer>>();  
    public List<List<Integer>> fourSum(int[] nums, int target) {
     Set<List<Integer>> hset = new HashSet<List<Integer>>();  
        
        if (nums == null || nums.length < 4) {return listAll;}  
        Arrays.sort(nums);  
        for (int i = 0; i < nums.length - 3; i++) {  
            for (int j = i + 1; j < nums.length - 2; j++) {  
                int p = j + 1;  
                int q = nums.length - 1;  
                while (p < q) {  
                    if (nums[i] + nums[j] + nums[p] + nums[q] == target) {  
                        List<Integer> list = new ArrayList<Integer>();  
                        list.add(nums[i]);  
                        list.add(nums[j]);  
                        list.add(nums[p]);  
                        list.add(nums[q]);  
                        if (!hset.contains(list)) {  
                            hset.add(list);  
                            listAll.add(list);  
                        }  
                        p++;  
                        q--;  
                    } else if (nums[i] + nums[j] + nums[p] + nums[q] < target) {  
                        p++;  
                    } else {  
                        q--;  
                    }  
                }  
            }  
        }  
        return listAll;  
    }  
}  