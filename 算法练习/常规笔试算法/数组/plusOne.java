/**
 *  加一

 给定一个非负数，表示一个数字数组，在该数的基础上+1，返回一个新的数组。

 该数字按照大小进行排列，最大的数在列表的最前面。

 样例
 给定 [1,2,3] 表示 123, 返回 [1,2,4].

 给定 [9,9,9] 表示 999, 返回 [1,0,0,0].
 */
/
public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     * 从digits高位开始累加，加完后发现仍有进位 扩充 数组长度
     */
    public int[] plusOne(int[] digits) {
        int size = digits.length;
        int tag = 1;
        for(int i = size -1; i >= 0; i--){
            if(digits[i] + tag >= 10){
                digits[i] = 0;
                tag = 1;
            }else{
                digits[i] = digits[i] + tag;
                tag = 0;
            }
        }
        if(tag == 1){
            int[] res = new int[size + 1];
            nums[0] = tag;
            for(int i = 0; i < size; i++){
                nums[i + 1] = digits[i];
                return nums;
            }
        }
        return digits;
    }
}