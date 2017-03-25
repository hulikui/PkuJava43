/** @important
 * 接雨水

 给出 n 个非负整数，代表一张X轴上每个区域宽度为 1 的海拔图, 计算这个海拔图最多能接住多少（面积）雨水。

 接雨水

 样例
 如上图所示，海拔分别为 [0,1,0,2,1,0,1,3,2,1,2,1], 返回 6.
 */
/
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     * 找到最高的海拔 indexMax 以此为分界线
     * 从左边开始 遇到比当前小的海拔 证明 l.. 洼地 比当前大的需要更新海拔 需要计算差值 直到靠近 indexMax
     * 从右边开始 同上
     */
    public int trapRainWater(int[] A) {
        int len = A.length;
        if(n <= 2) return 0;
        int maxIndex = 0;
        int max = 0;
        for(int i=0; i<len; i++){
            if(A[i] > max){
                max = A[i];
                maxIndex = i;
            }
        }
        int area = 0;
        int root = 0;
        for(i = 0; root = A[0]; i < maxIndex; i++){
            if(A[i] > root){
                root = A[i];
            }else{
                area += root - A[i];
            }
        }
        for(i = len - 1; root = A[len - 1]; i > maxIndex; i++){
            if(A[i] > root){
                root = A[i];
            }else{
                area += root - A[i];
            }
        }
        return area;

    }
}