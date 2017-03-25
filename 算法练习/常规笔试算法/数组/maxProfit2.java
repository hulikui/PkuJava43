/**
 *  买卖股票的最佳时机 II

 假设有一个数组，它的第i个元素是一个给定的股票在第i天的价格。设计一个算法来找到最大的利润。你可以完成尽可能多的交易(多次买卖股票)。然而,你不能同时参与多个交易(你必须在再次购买前出售股票)。

 样例
 给出一个数组样例[2,1,2,0,1], 返回 2
 */
/
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * 找到每一处的 峰谷和峰顶 累计相加之间的差值
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;
        int start = 0;
        int end = 1;
        int count = 0;
        while(end < prices.length){
            if(prices[start] > prices[end]){
                start++;
                end++;
            }else{
                while(end < prices.length - 1 && prices[end] < prices[end + 1]){
                    end++;
                }
                count = prices[end] - prices[start] + count;
                end = end + 2;
                start = end - 1;
                if(end >= prices.length) return count;
            }
        }
        return count;
    }
}