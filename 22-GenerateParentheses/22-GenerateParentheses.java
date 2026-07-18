// Last updated: 7/18/2026, 9:01:37 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        // Start the recursive backtracking with 0 open and 0 close brackets
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base Case: If the string reaches the required length, add it to the list
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Rule 1: We can add an opening parenthesis if we haven't reached the limit 'max'
        if (open < max) {
            current.append('(');
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Rule 2: We can add a closing parenthesis if it doesn't exceed the number of open ones
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}