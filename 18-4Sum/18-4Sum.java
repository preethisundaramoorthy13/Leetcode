// Last updated: 7/17/2026, 9:54:26 PM
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<String> generateParenthesis(int n) {
6        List<String> result = new ArrayList<>();
7        // Start the recursive backtracking with 0 open and 0 close brackets
8        backtrack(result, new StringBuilder(), 0, 0, n);
9        return result;
10    }
11
12    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
13        // Base Case: If the string reaches the required length, add it to the list
14        if (current.length() == max * 2) {
15            result.add(current.toString());
16            return;
17        }
18
19        // Rule 1: We can add an opening parenthesis if we haven't reached the limit 'max'
20        if (open < max) {
21            current.append('(');
22            backtrack(result, current, open + 1, close, max);
23            current.deleteCharAt(current.length() - 1); // Backtrack
24        }
25
26        // Rule 2: We can add a closing parenthesis if it doesn't exceed the number of open ones
27        if (close < open) {
28            current.append(')');
29            backtrack(result, current, open, close + 1, max);
30            current.deleteCharAt(current.length() - 1); // Backtrack
31        }
32    }
33}