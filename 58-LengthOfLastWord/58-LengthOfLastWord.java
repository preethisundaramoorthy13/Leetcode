// Last updated: 7/18/2026, 9:00:56 PM
class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;
        int count = 0;

        // Step 1: skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: count last word
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}