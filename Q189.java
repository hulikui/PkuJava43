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
		if(nums.length-1<k||k==0){
			return;
		}
		int[] temp = new int[nums.length];
		int j = nums.length-k;
		for(int i = 0;i<temp.length;i+=k){
			int temp_i = i;
			int temp_j = j;
			for(int m =0;m<=k;m++){
				if(temp_j>nums.length-1|| temp_i>nums.length-1)
					break;
				temp[temp_j] = nums[temp_i];
				temp_i++;
				temp_j++;
			}
			j = j-k>0?j-k:0;
			
			if(temp_i>nums.length-1)
				break;
		}
		nums = temp;
	}
    
    public static void main(String[] args) {
		Q189 q = new Q189();
		int[] nums = {1,2};
		q.rotate(nums, 1);
	}
}
