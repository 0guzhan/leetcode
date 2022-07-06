package com.acargil.leetcode.blind75.array;

import org.junit.jupiter.api.Assertions;

public class BestTimeBuyAndSellStock {

  public static void main(String[] args) {
    BestTimeBuyAndSellStock bestTimeBuyAndSellStock = new BestTimeBuyAndSellStock();
    BestTimeBuyAndSellStock.Solution solution = bestTimeBuyAndSellStock.new Solution();
    int maxProfit = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    Assertions.assertEquals(5, maxProfit);
    maxProfit = solution.maxProfit(new int[]{7, 6, 4, 3, 1});
    Assertions.assertEquals(0, maxProfit);
  }

  class Solution {

    public int maxProfit(int[] prices) {
      int maxProfit = 0;
      for (int i = 0, j = 1; j < prices.length; j++) {
        int profit = prices[j] - prices[i];
        if (profit <= 0) {
          i = j;
        } else if (profit > maxProfit) {
          maxProfit = profit;
        }
      }
      return maxProfit;
    }
  }
}
