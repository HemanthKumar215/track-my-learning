/*
 * LeetCode 121 · Best Time to Buy and Sell Stock · Easy
 * Done on: Mon 16 – Tue 17 Nov 2026 (revision: re-solved)
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Question: prices[i] is the price on day i. Buy on one day and sell on a LATER day.
 * Return the maximum profit, or 0 if no profit is possible.
 * Examples: [7,1,5,3,6,4] -> 5 (buy 1, sell 6), [7,6,4,3,1] -> 0, [2,4,1] -> 2
 *
 * Solution 1 (brute force): try every (buy i, sell j > i) pair. O(n^2) -> TLE for n = 100,000.
 * Solution 2 (one pass): treat each day as the SELL day. The best buy day is the cheapest
 *   price seen before it, so keep minPrice. profit = price - minPrice, keep the best.
 *   day: price minPrice profit best
 *    0:   7      7       0     0
 *    1:   1      1       0     0
 *    2:   5      1       4     4
 *    4:   6      1       5     5
 * Time O(n), Space O(1).
 *
 * My notes: wrote the brute force first (j = i + 1 so selling is after buying, best = 0 for
 * falling prices). Key observation (with help): to sell today, buy at the minimum so far.
 * Then wrote the one-pass version; only forgot `int` on minPrice and the final return.
 */
public class LC0121_BestTimeToBuySellStock {

    static class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int best = 0;
            for (int i = 1; i < prices.length; i++) {
                int diff = prices[i] - minPrice;
                if (prices[i] < minPrice) minPrice = prices[i];
                if (diff > best) best = diff;
            }
            return best;
        }

        public int maxProfitBrute(int[] prices) {
            int best = 0;
            int n = prices.length;
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    if (prices[j] - prices[i] > best) best = prices[j] - prices[i];
            return best;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] tests = {{7, 1, 5, 3, 6, 4}, {7, 6, 4, 3, 1}, {2, 4, 1}, {5}, {3, 8, 1, 4}};
        for (int[] t : tests)
            System.out.println(s.maxProfit(t) + " " + s.maxProfitBrute(t));   // 5 0 2 0 5
    }
}
