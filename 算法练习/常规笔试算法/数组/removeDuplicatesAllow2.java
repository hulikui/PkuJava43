/** @important
 * 删除排序数组中的重复数字 II

 跟进“删除重复数字”：

 如果可以允许出现两次重复将如何处理？
 */
/
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     * 设置一个 flag 标识是否是含有相同元素的第一次比较
     * 一个临时temp 变量 存储上一个第一次比较的数
     * A[index++] = A[i] 操作问题
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int temp = -1;
        boolean flag = false;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != temp){// 证明第一次比较
                nums[i] = temp;
                nums[index++] = nums[i];
                flag = true;
            }else if(flag){
                flag = false;
                nums[index++] = nums[i];
            }
        }
    }
}