/**
 * 最小调整代价

 给一个整数数组，调整每个数的大小，使得相邻的两个数的差小于一个给定的整数target，调整每个数的代价为调整前后的差的绝对值，求调整代价之和最小是多少。

 注意事项

 你可以假设数组中每个整数都是正整数，且小于等于100。

 样例
 对于数组[1, 4, 2, 3]和target=1，最小的调整方案是调整为[2, 3, 2, 3]，调整代价之和是2。返回2。
 */
/
public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     * cost[i][j] = Math.min(cost[i-1][j])
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {

    }
}