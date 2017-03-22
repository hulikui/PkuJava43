/*
*  搜索旋转排序数组

假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。

你可以假设数组中不存在重复的元素。

给出[4, 5, 1, 2, 3]和target=1，返回 2

给出[4, 5, 1, 2, 3]和target=0，返回 -1
* */
public class Solution {
    /**
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     *  二分查找确定递增区间
     */
    public int search(int[] A, int target) {
        return BinarySearch(A, target, 0, A.length - 1);
    }
    public int BinarySearch(int A, int target, int l, int r){
        if(l > r) return -1;
        int mid = (l + r) / 2;
        if(A[mid] == target) return mid;
        // 重点在怎么确定递增区间
        if(A[mid] < A[l]){// 翻转过的 左大右小
            if(A[mid] >= target && target <= A[r]){
                return BinarySearch(A, target, mid + 1, r);
            }else{
                return BinarySearch(A, target, l, mid - 1);
            }
        }else{// 未翻转
            if(target >= A[l] && target <= A[mid]){
                return BinarySearch(A, target, l, mid - 1);
            }else{
                return BinarySearch(A, target, mid + 1, r);
            }

        }
    }
}