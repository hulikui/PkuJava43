public class Solution {
/**
 * @param A an integer array
 * @return void
 * 默认升序
 */
    public void QuickSort(int[] A, int l, int r){
        if(l < r){
            int i = l;
            int j = r;
            int temp = A[i];
            while(i < j){
                while(i < j && A[j] >= temp) j--;//从右找到比基准小的
                if(i < j) A[i++] = A[j];// 始终空出来一个位置 以供符合交换
                while(i < j && A[i] <= temp) i++;// 从左边找到比基准大的
                if(i < j) A[j--] = A[i];
            }
            A[i] = temp;
            QuickSort(A, l, i - 1);// 递归 + 分治
            QuickSort(A, i + 1, r);
        }
    }
}