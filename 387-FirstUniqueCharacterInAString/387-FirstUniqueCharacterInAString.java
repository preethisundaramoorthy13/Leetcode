// Last updated: 7/17/2026, 3:03:33 PM
class Solution {
    static {
        for (int i = 0; i < 300; i++)
            firstUniqChar("");
    }
    public static int firstUniqChar(String s) {
        
        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(freq[s.charAt(i) - 'a'] == 1) return i; 
        }

        return -1;

    }
}