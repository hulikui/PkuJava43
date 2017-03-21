public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int nums, int target){
        int start = 0;
        int end = nums.length;
        while(start < end){
            int mid = (start + end) / 2;
            if(nums[mid]) return mid;
            else if(nums[mid] > target) end = mid - 1;
            else if(nums[mid] < target) start = mid + 1;
        }
        return -1;
    }
}