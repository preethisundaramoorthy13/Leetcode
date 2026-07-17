// Last updated: 7/17/2026, 3:03:01 PM
class Solution {
    public int calPoints(String[] operations) {
        int count = 0;

        int p = -1;
        int[] s = new int[operations.length];

        for(int i = 0; i < operations.length; i++) {
            String o = operations[i];

            if("C".equals(o)) {
                count -= s[p--];
            } else if("D".equals(o)) {
                s[p + 1] = s[p] * 2;
                count += s[++p];
            } else if("+".equals(o)) {
                s[p + 1] = s[p] + s[p - 1];
                count += s[++p];
            } else {
                s[++p] = Integer.parseInt(o);
                count += s[p];
            }
        }

        return count;
    }
}