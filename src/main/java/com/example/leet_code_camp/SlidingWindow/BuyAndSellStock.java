package com.example.leet_code_camp.SlidingWindow;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {

            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                left++;
            }
            else {
                left = right;
            }

            right++;
        }


        return maxProfit;
    }
}
