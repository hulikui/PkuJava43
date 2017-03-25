/**
 *  最大子数组

 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。

 注意事项

 子数组最少包含一个数

 样例
 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
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
        int maxsum = nums[0];
        for(int i=0; i<nums.length; i++){
            cursum = nums[i] > nums[i] + cursum ? nums[i] : nums[i] + cursum;
            maxsum = Math.max(cursum, maxsum);
        }
        return maxsum;
    }
}