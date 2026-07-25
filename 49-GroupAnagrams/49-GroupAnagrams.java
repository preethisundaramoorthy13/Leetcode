// Last updated: 7/25/2026, 2:00:19 PM
1class Solution {
2    public double myPow(double x, int n) {
3        long N = n;
4        if (N < 0) {
5            x = 1 / x;
6            N = -N;
7        }
8
9        double ans = 1;
10        double currentProduct = x;
11
12        while (N > 0) {
13            if (N % 2 == 1) {
14                ans = ans * currentProduct;
15            }
16            currentProduct = currentProduct * currentProduct;
17            N /= 2;
18        }
19
20        return ans;
21    }
22}