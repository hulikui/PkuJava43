/**
 * @important
 * 删除排序数组中的重复数字

给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。

不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。

样例
给出数组A =[1,1,2]，你的函数应该返回长度2，此时A=[1,2]。
 */
/
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     * 利用 index 维护数组当前已删除后新组建的数组长度
     */
    public int removeDuplicates(int[] nums) {
         int len = nums.length;
         if(len == 0) return 0;
         int index = 1;
         for(int i = 1; i < len; i++){
             if(nums[i-1] == nums[i]){
                 break;
             }else{
                 nums[index++] = nums[i]; // 组建新数组的做法
             }
         }
         return index;
    }
}