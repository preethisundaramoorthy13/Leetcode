// Last updated: 7/18/2026, 9:02:03 PM
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}