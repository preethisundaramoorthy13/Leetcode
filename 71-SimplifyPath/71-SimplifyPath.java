// Last updated: 7/18/2026, 5:58:01 AM
class Solution {
    public String simplifyPath(String path) {
        int n = path.length();
        char[] c = new char[n+1];
        int[] starts = new int[n+1];
        int p=0;
        int pStr = 0;
        for (int i=0; i< n; i++){
            while (i < n && path.charAt(i) == '/')i++;
            if (i >=n) break;
            int start = i;
            while (i < n && path.charAt(i) != '/') i++;
            int len = i - start;
            if (len == 1 && path.charAt(start) == '.')continue;
            if (len == 2 && path.charAt(start) == '.' && path.charAt(start+1) == '.'){
                if (pStr > 0) {
                    p = starts[--pStr]; 
                }
                continue;
            }
            starts[pStr++] = p;
            c[p++] = '/';
            for (int j= start; j< i; j++) c[p++] = path.charAt(j);
        }
        return (p == 0)? "/" : new String(c,0,p);
    }
}