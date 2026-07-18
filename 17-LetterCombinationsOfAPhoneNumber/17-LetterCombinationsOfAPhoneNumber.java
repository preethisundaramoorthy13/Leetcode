// Last updated: 7/18/2026, 9:01:44 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    // Mapping of digits 2-9 to their corresponding letters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: if input is empty, return empty list
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start backtracking from index 0
        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // Base case: if we've processed all digits, add the combination to the result
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];
        
        // Loop through each letter and recurse
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));          // Choose
            backtrack(result, digits, current, index + 1); // Explore
            current.deleteCharAt(current.length() - 1); // Unchoose (Backtrack)
        }
    }
}