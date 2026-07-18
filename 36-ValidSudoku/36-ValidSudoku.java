// Last updated: 7/18/2026, 5:10:32 PM
1class Solution {
2    public String countAndSay(int n) {
3        if (n <= 0) return "";
4        
5        String result = "1";
6        for (int i = 1; i < n; i++) {
7            StringBuilder sb = new StringBuilder();
8            int count = 1;
9            
10            for (int j = 1; j < result.length(); j++) {
11                if (result.charAt(j) == result.charAt(j - 1)) {
12                    count++;
13                } else {
14                    sb.append(count).append(result.charAt(j - 1));
15                    count = 1;
16                }
17            }
18            sb.append(count).append(result.charAt(result.length() - 1));
19            result = sb.toString();
20        }
21        
22        return result;
23    }
24}