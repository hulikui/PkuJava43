/** @important
 *  和大于S的最小子数组

 给定一个由 n 个整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。

 样例
 给定数组 [2,3,1,2,4,3] 和 s = 7, 子数组 [4,3] 是该条件下的最小长度子数组
 */
/
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     * 累加到 sum >= s 可以从前部分一个个删除元素 并 更新 长度直到不满足 sum >=s 继续累加，重复以上
     */
    public int minimumSize(int[] nums, int s) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        while(end < nums.length){
            sum += nums[end];
            if(sum >= s){
                while(sum >= s && start <= end){
                    res = Math.min(res, end - start + 1);
                    sum -= nums[start++];
                }
            }
            end++;
        }
        if(res == Integer.MIN_VALUE) return -1;
        return res;
    }
}