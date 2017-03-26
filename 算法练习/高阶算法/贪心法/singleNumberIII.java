/**
 * 落单的数 III

 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。

 样例
 给出 [1,2,2,3,4,4,5,3]，返回 1和5
 */
/
public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     * ArrayList api indexOf 因为是其他元素是2次 第一次不包含就插入arraylist内 第二次如果存在 就直接删除， 最后没删除的一定是那剩下的两个数
     */
    public List<Integer> singleNumberIII(int[] A) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<A.length; i++){
            int index = res.indexOf(A[i]);
            if(index == -1){
                res.add(A[i]);
            }else{
                res.remove(index);
            }
        }
        return res;
    }
}