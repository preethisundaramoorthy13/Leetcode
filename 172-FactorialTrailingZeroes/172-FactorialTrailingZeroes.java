// Last updated: 9/22/2026, 9:35:55 AM
1class Solution {
2    public int maxProfit(int k, int[] prices) {
3        int n = prices.length;
4        if (n <= 1 || k == 0) {
5            return 0;
6        }
7
8        // Optimization: If k >= n / 2, we can make as many transactions as we want
9        // (Equivalent to Best Time to Buy and Sell Stock II)
10        if (k >= n / 2) {
11            int maxProfit = 0;
12            for (int i = 1; i < n; i++) {
13                if (prices[i] > prices[i - 1]) {
14                    maxProfit += prices[i] - prices[i - 1];
15                }
16            }
17            return maxProfit;
18        }
19
20        // buy[j] stores the max profit with at most j transactions while holding a stock
21        // sell[j] stores the max profit with at most j transactions while holding no stock
22        int[] buy = new int[k + 1];
23        int[] sell = new int[k + 1];
24
25        for (int j = 0; j <= k; j++) {
26            buy[j] = Integer.MIN_VALUE;
27            sell[j] = 0;
28        }
29
30        for (int price : prices) {
31            for (int j = 1; j <= k; j++) {
32                buy[j] = Math.max(buy[j], sell[j - 1] - price);
33                sell[j] = Math.max(sell[j], buy[j] + price);
34            }
35        }
36
37        return sell[k];
38    }
39}