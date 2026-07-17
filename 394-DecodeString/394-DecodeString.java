// Last updated: 7/17/2026, 3:03:31 PM
class Solution {
    public String decodeString(String s) {
        int[] index = new int[]{0};
        return decode(s, index);
    }
    private String decode (String s, int[] index) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int num = 0;
        while (index[0] < n) {
            char c = s.charAt(index[0]);

            if (Character.isLetter(c)) {
                sb.append(c);
                index[0]++;
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                index[0]++;
            } else if (c == '[') {
                index[0]++;
                String subString = decode(s, index);
                while (num > 0) {
                    sb.append(subString);
                    num--;
                }
            } else if (c == ']') {
                index[0]++;
                return sb.toString();
            }
        }
        return sb.toString();
    }
}