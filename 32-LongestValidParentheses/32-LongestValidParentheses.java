// Last updated: 7/18/2026, 3:12:51 PM
1import java.util.Stack;
2
3class Solution {
4    public int longestValidParentheses(String s) {
5        Stack<Integer> stack = new Stack<>();
6        // Push -1 onto the stack to act as a base for the first valid substring
7        stack.push(-1);
8        int maxLength = 0;
9
10        for (int i = 0; i < s.length(); i++) {
11            char c = s.charAt(i);
12
13            if (c == '(') {
14                // Store the index of the opening parenthesis
15                stack.push(i);
16            } else {
17                // Pop the last matching opening parenthesis or base index
18                stack.pop();
19
20                if (stack.isEmpty()) {
21                    // If empty, this ')' is unmatched; push its index as the new base
22                    stack.push(i);
23                } else {
24                    // Calculate the length of the current valid substring
25                    maxLength = Math.max(maxLength, i - stack.peek());
26                }
27            }
28        }
29
30        return maxLength;
31    }
32}