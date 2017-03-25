/**
 * 下一个排列

 给定一个若干整数的排列，给出按正数大小进行字典序从小到大排序后的下一个排列。

 如果没有下一个排列，则输出字典序最小的序列。

 样例
 左边是原始排列，右边是对应的下一个排列。

 1,2,3 → 1,3,2

 3,2,1 → 1,2,3

 1,1,5 → 1,5,1
 */
/
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     * 从后往前找到 第一组 后面的nums[j] 大于前面的数nums[i]， 交换顺序后 把下标 i+1一直到 len 重新排序
     * Arrays.sort(nums, i+1, nums.length);
     */
    public void nextPermutation(int[] nums) {
        for(int i = nums.length-1; i >= 0; i--){
            for(int j = nums.length-1; j > i; j--){
                if(nums[j] > nums[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    Arrays.sort(nums, i+1, nums.length);
                }
            }
        }
        Arrays.sort(nums);
    }
}