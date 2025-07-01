package com.example.leet_code_camp.SlidingWindow;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int left = 0; // Buy day
        int right = 1; // Sell day
        int maxProfit = 0;

        while (right < prices.length) {
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // If we find a lower price, we move buy day to the current right
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
