/**
 *   恢复旋转排序数组

 给定一个旋转排序数组，在原地恢复其排序。

 说明
 什么是旋转数组？

 比如，原始数组为[1,2,3,4], 则其旋转数组可以是[1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 样例
 [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 */
/
public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     * 找到分界线 前大后小
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int len = nums.size();
        int i = 0;
        while(i < len - 1 && nums[i+1] > nums[i]) i++;
        if(i == len - 1) return; // 证明没有翻转
        for(int m = 0; m <= i; i++){
            int temp = nums.get(0);// 每次往前依次推一个元素
            for(int p = 1; p < len; p++){
                nums.set(p-1, nums.get(p));
            }
            nums.set(len - 1, temp);
        }
    }
}
