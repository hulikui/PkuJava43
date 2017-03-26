/** @important
 * 房屋染色

 这里有n个房子在一列直线上，现在我们需要给房屋染色，分别有红色蓝色和绿色。每个房屋染不同的颜色费用也不同，你需要设计一种染色方案使得相邻的房屋颜色不同，并且费用最小。

 费用通过一个nx3 的矩阵给出，比如cost[0][0]表示房屋0染红色的费用，cost[1][2]表示房屋1染绿色的费用。

 注意事项

 所有费用都是正整数

 样例
 costs = [[14,2,11],[11,14,5],[14,3,10]] return 10

 房屋 0 蓝色, 房屋 1 绿色, 房屋 2 蓝色， 2 + 5 + 3 = 10
 */
/
public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     * 在原数组上动规，每一行对应一个房子，每一个元素代表从第一行的房子到这一行的房子选择这一种颜色所花的最小开销。所以每个元素 = 该元素的值 + 上一行两个与该元素不同列元素的值的较小者。
     */
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int len = costs.length;
        for(int i = 1; i<len; i++){
            costs[i][0] += costs[i-1][1] + costs[i-1][2];
            costs[i][1] += costs[i-1][2] + costs[i-1][0];
            costs[i][2] += costs[i-1][0] + costs[i-1][1];
        }
        return Math.min(costs[0], Math.min(costs[1], costs[2]));
    }
}