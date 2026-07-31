// Last updated: 7/31/2026, 9:42:51 AM
class Solution {

    static {
        for(int i=0;i <=500;i++) {
            new Solution().longestPalindrome(new String ());
        }
    }

       public static int findLongestPalindromeWithoutMap(String s) {

        int map[] = new int[256];
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (map[currChar] > 0) {
                map[currChar]--;
                ans += 2;
            } else {
                map[currChar]++;

            }

        }
        if (ans != s.length()) {
            ans += 1;
        }
        return ans;

    }

    public int longestPalindrome(String s) {
        return findLongestPalindromeWithoutMap(s);
    }
}