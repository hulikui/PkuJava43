/** @important
 * 数字三角形

 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。

 注意事项

 如果你只用额外空间复杂度O(n)的条件下完成可以获得加分，其中n是数字三角形的总行数。

 样例
 比如，给出下列数字三角形：

 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
 */
/
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     * 从最后一行开始 累加最小的数到上一行，直到顶部[0][0]
     * 自底往上，把每一行的元素改为其下一行能与之相加的两个数得到的和的最小值
     */
    public int minimumTotal(int[][] triangle) {
        int row = triangle.length;
        if(row == 0) return 0;
        if(row == 1) return triangle[0][0];
        for(int i=row-2; i>=0; i--){
            for (int j=0; j<triangle[i].length; j++){
                int min = Math.min(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j];
                triangle[i][j] = min;
            }
        }
        return triangle[0][0];
    }
}