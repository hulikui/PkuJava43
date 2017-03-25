/** @important
 * 买卖股票的最佳时机

 假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。

 样例
 给出一个数组样例 [3,2,3,1,2], 返回 1
 */
/
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     * 申请两个变量
     * minBuy 表示最小的买进
     * res 表示 最大利润
     * 注意minBug 始终在res前面 同步更新
     * 最小的购买 最大的卖
     * 模拟过程
     */
    public int maxProfit(int[] prices) {
        int res = 0;
        int minBuy = prices[0];
        for(int i=1; i<prices.length; i++){
            res = Math.max(res, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
    }
}