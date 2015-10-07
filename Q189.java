package leetcode;

public class Q189 {
//    public void rotate(int[] nums, int k) {
//    	if(nums.length == 1 || nums.length<2*k){
//    		return;
//    	}
//    	 int[] temp = new int[nums.length];
//    	 int j = 0;
//         for(int i = nums.length-k;i>=0;i-=k){
//        	 int temp_i = i;
//        	 if(temp_i-k<0){
//        		 temp_i = 0;
//        		 k += i - temp_i;
//        	 }
//        	 
//        	 
//        	 for(int m=0;m<k;m++){
//        		 temp[j] = nums[temp_i];
//        		 temp_i++;
//        		 j++;
//        	 }
//        	 if(temp_i-k == 0 ){
//        		 break;
//        	 }
//         }
//    }
	
	public void rotate(int[] nums, int k) {
	    if (nums == null || nums.length == 0) return;
	    int length = nums.length;
	    k = k % length;
	    reverse(nums, 0, length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int tmp = nums[start];
	        nums[start++] = nums[end];
	        nums[end--] = tmp;
	    }
	}
    
    public static void main(String[] args) {
		Q189 q = new Q189();
		int[] nums = {1,2};
		q.rotate(nums, 1);
	}
}
