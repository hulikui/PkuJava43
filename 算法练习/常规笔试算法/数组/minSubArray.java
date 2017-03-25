/**
 *  最小子数组

 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。

 注意事项

 子数组最少包含一个数字

 样例
 给出数组[1, -1, -2, 1]，返回 -3
 */
/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     * 遍历累加 当当前结点大于累计和的时候 切换累计和
     */
    public int maxSubArray(int[] nums) {
        int cursum = 0;
        int minsum = nums[0];
        for(int i=0; i<nums.length; i++){
            cursum = nums[i] < nums[i] + cursum ? nums[i] : nums[i] + cursum;
            minsum = Math.min(cursum, maxsum);
        }
        return maxsum;
    }
}