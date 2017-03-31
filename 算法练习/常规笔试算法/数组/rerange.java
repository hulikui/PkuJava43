/**
 * 交错正负数

 给出一个含有正整数和负整数的数组，重新排列成一个正负数交错的数组。

 注意事项

 不需要保持正整数或者负整数原来的顺序。

 样例
 给出数组[-1, -2, -3, 4, 5, 6]，重新排序之后，变成[-1, 5, -2, 4, -3, 6]或者其他任何满足要求的答案
 */
/
class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     * 计算出 负数和整数 谁的个数多
     * 如果 负数多 第一个数应该是 负数
     * 整数多 第一个数应该是正数
     * 遍历到一个正数（负数） 替换现在遍历的位置 交替 替换 正负数
     */
    public void rerange(int[] A) {
        int pos = 0;
        int neg = 0;
        for(int a : A){
            if(a > 0) pos++;
            else{
                neg++;
            }
        }
        boolean plus = false;
        if(pos > neg) plus = true;
        int i = 0;
        int j = 0;
        while(A[i] > 0){
            i++;
        }
        while(A[j] < 0){
            j++;
        }
        int cur = 0;
        while(cur < A.length){
            if(plus){
                int temp = A[cur];
                A[cur] = A[i];
                A[i] = temp;
                i++;
                while(i < A.length && A[i] < 0) i++;
                while(j < A.length && A[j] > 0) j++;
            }else{
                int temp = A[cur];
                A[cur] = A[j];
                A[j] = temp;
                j++;
                while(i < A.length && A[i] < 0) i++;
                while(j < A.length && A[j] > 0) j++;
            }
            plus = !plus;
            cur++;
        }
    }
}