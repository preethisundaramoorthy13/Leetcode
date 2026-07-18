// Last updated: 7/18/2026, 9:01:28 PM
class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; 
            }
        }
        
        return -1;
    }
}