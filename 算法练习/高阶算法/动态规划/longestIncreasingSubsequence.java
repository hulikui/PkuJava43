/**
 * 最长上升子序列

 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。

 说明
 最长上升子序列的定义：

 最长上升子序列问题是在一个无序的给定序列中找到一个尽可能长的由低到高排列的子序列，这种子序列不一定是连续的或者唯一的。
 https://en.wikipedia.org/wiki/Longest_increasing_subsequence

 样例
 给出 [5,4,1,2,3]，LIS 是 [1,2,3]，返回 3
 给出 [4,2,4,5,3,7]，LIS 是 [2,4,5,7]，返回 4
 */
/
public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     *
     * 假设dp[i]代表加入第i个数能构成的最长升序序列长度，
     * 我们就是要在dp[0]到dp[i-1]中找到一个最长的升序序列长度，
     * 又保证序列尾值nums[j]小于nums[i]，然后把这个长度加上1就行了。
     * 同时，我们还要及时更新最大长度。
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 0;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                // 求 dp[0] 到 dp[i-1]内 LIS
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            //加1就是该位置能构成的最长升序序列长度??
            dp[i] += 1;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}