/** @important
 * 乘积最大子序列

 找出一个序列中乘积最大的连续子序列（至少包含一个数）。

 样例
 比如, 序列 [2,3,-2,4] 中乘积最大的子序列为 [2,3] ，其乘积为6。
 */
/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     * pos 维护最大的数 neg 维护最小的数 有可能是负数
     */
    public int maxProduct(int[] nums) {
        // write your code here
        // 都有特殊意义 规律
        int pos = nums[0];
        int neg = nums[0];
        int max = nums[0];
        for(int i = 1; i<nums.length; i++){
            pos = Math.max(nums[i], Math.max(nums[i] * pos, nums[i] * neg));
            neg = Math.min(nums[i], Math.min(nums[i] * pos, nums[i] * neg));
            max = Math.max(pos, max);
        }
        return max;
    }
}