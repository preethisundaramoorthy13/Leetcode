// Last updated: 7/17/2026, 9:09:17 PM
1class Solution {
2    public String convert(String s, int numRows) {
3        // Edge cases: if numRows is 1 or string length is less than numRows, no conversion needed
4        if (numRows == 1 || s.length() <= numRows) {
5            return s;
6        }
7
8        // Initialize a List of StringBuilders for each row
9        List<StringBuilder> rows = new ArrayList<>();
10        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
11            rows.add(new StringBuilder());
12        }
13
14        int currRow = 0;
15        boolean goingDown = false;
16
17        // Iterate through each character in the string
18        for (char c : s.toCharArray()) {
19            rows.get(currRow).append(c);
20            
21            // If we reach the top or bottom row, change direction
22            if (currRow == 0 || currRow == numRows - 1) {
23                goingDown = !goingDown;
24            }
25            
26            // Move up or down based on the direction flag
27            currRow += goingDown ? 1 : -1;
28        }
29
30        // Combine all rows into a single string
31        StringBuilder result = new StringBuilder();
32        for (StringBuilder row : rows) {
33            result.append(row);
34        }
35
36        return result.toString();
37    }
38}