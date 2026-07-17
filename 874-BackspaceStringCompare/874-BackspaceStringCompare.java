// Last updated: 7/17/2026, 3:02:51 PM
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidIndex(s, i);
            j = getNextValidIndex(t, j);

            char nextI = (i >= 0) ? s.charAt(i) : '#';
            char nextJ = (j >= 0) ? t.charAt(j) : '#';

            if (nextI == '#' && nextJ == '#') {
                return true;
            }

            if (nextI != nextJ) {
                return false;
            }
            
            i--;
            j--;
        }

        return true;
    }

    // if has not next valid char - return -1
    private int getNextValidIndex(String s, int index) {
        int skip = 0;

        while (index >= 0) {
            char c = s.charAt(index);
            if (c == '#') {
                skip++;
            } else if (skip > 0) {
                skip--;
            } else {
                break;
            }

            index--;
        }

        return index;
    }
}