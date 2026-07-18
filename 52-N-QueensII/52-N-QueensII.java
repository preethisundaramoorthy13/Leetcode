// Last updated: 7/18/2026, 9:13:59 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public String getPermutation(int n, int k) {
6        int[] factorial = new int[n];
7        List<Integer> numbers = new ArrayList<>();
8        
9        factorial[0] = 1;
10        for (int i = 1; i < n; i++) {
11            factorial[i] = factorial[i - 1] * i;
12        }
13        
14        for (int i = 1; i <= n; i++) {
15            numbers.add(i);
16        }
17        
18        k--;
19        StringBuilder sb = new StringBuilder();
20        
21        for (int i = n - 1; i >= 0; i--) {
22            int index = k / factorial[i];
23            sb.append(numbers.get(index));
24            numbers.remove(index);
25            k %= factorial[i];
26        }
27        
28        return sb.toString();
29    }
30}