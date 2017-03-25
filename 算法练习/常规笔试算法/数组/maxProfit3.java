/** @important
 * 买卖股票的最佳时机 III

 假设你有一个数组，它的第i个元素是一支给定的股票在第i天的价格。设计一个算法来找到最大的利润。你最多可以完成两笔交易。

 注意事项

 你不可以同时参与多笔交易(你必须在再次购买前出售掉之前的股票)

 样例
 给出一个样例数组 [4,4,6,1,1,4,2,5], 返回 6
 */
/
class Solution {
/**
 * @param prices: Given an integer array
 * @return: Maximum profit
 * 要求交易两次 化解成 I 题的 左右各一次， 那么就一共两次了
 */
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i<prices.length; i++){
            int sum = getMaxProfit(prices, 0, i) + getMaxProfit(prices, i+1, prices.length - 1);
            res = Math.max(res, sum);
        }
        return res;
    }
    public int getMaxProfit(int[] prices, int start, int end){
        if(start >= end) return 0;
        int res = 0;
        int minBug = prices[start];
        for(int i= stat+1; i<=end; i++){
            res = Math.max(res, prices[i] - minBug);
            minBug = Math.min(minBug, prices[i]);
        }
        return res;
    }
}