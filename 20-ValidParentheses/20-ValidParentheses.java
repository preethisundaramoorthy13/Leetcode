// Last updated: 7/18/2026, 9:01:40 PM
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false;
        return isValid(0, ' ', s.toCharArray()) > 0;
    } 
    private int isValid(int i, char last, char[] s) {
        if(i == s.length) return i;
        if(i > s.length) return - 1;
        if(s[i] == '(' || s[i] == '[' || s[i] == '{') {
            int next = isValid(i + 1, s[i], s);
            if(next < 0) return -1;
            else return isValid(next + 1, last, s);
        }
        if(last == '(' && s[i] == ')' || last == '[' && s[i] == ']' || last == '{' && s[i] == '}') return i;
        return -1;
    }
}