// Last updated: 9/21/2026, 5:59:36 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public String fractionToDecimal(int numerator, int denominator) {
6        if (numerator == 0) {
7            return "0";
8        }
9
10        StringBuilder sb = new StringBuilder();
11
12        if ((numerator < 0) ^ (denominator < 0)) {
13            sb.append("-");
14        }
15
16        long num = Math.abs((long) numerator);
17        long den = Math.abs((long) denominator);
18
19        sb.append(num / den);
20        long remainder = num % den;
21
22        if (remainder == 0) {
23            return sb.toString();
24        }
25
26        sb.append(".");
27        Map<Long, Integer> map = new HashMap<>();
28
29        while (remainder != 0) {
30            if (map.containsKey(remainder)) {
31                sb.insert(map.get(remainder), "(");
32                sb.append(")");
33                break;
34            }
35
36            map.put(remainder, sb.length());
37            remainder *= 10;
38            sb.append(remainder / den);
39            remainder %= den;
40        }
41
42        return sb.toString();
43    }
44}