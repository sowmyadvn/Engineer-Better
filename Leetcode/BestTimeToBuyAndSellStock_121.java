/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.

*/
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max_profit = 0;
        for(int i = 0; i < prices.length; i++) {
            //Keep updating min
            if(min > prices[i]) {
                min = prices[i];
            }
            //Else keep updating max_profit
            else if(prices[i]-min > max_profit) {
                max_profit = prices[i] - min;
            }
        }
        return max_profit;
    }
}