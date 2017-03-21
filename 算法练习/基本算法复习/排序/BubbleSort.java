public class Solution {
/**
 * @param A an integer array
 * @return void
 * 默认升序
 */
    public void BubbleSort(int[] A){
        int len = A.length;
        int count = 0;// 统计交换次数 优化操作 便于提前结束循环
        for(int i=0; i < len; i++){
            for(int j=1; j<len - i; j++){// len-i 是因为每次都有个元素排列在了最终位置
                if(A[j-1] > A[j]){
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                    count ++;
                }
            }
            if(count == 0) break;
            count = 0;
        }
    }
}