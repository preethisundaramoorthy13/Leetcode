// Last updated: 7/31/2026, 9:27:22 AM
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int mLen = magazine.length();
        int rLen = ransomNote.length();

        if (mLen < rLen) return false;

        int[] freq = new int[26];

        for (char ch : ransomNote.toCharArray()) {
            int i = magazine.indexOf(ch, freq[ch - 'a']);
            if (i == -1) return false;
            freq[ch - 'a'] = i + 1;
        }

        return true;
    }
}