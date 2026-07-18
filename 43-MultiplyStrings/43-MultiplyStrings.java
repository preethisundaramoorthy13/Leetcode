// Last updated: 7/18/2026, 9:01:05 PM
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        if ("1".equals(num1))
            return num2;
        if ("1".equals(num2))
            return num1;

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int m = c1.length, n = c2.length;

        int[] vals = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int n1 = c1[i] - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = c2[j] - '0';
                vals[i + j + 1] += n1 * n2;
            }
        }
        int carry = 0;
        for (int i = vals.length - 1; i >= 0; i--) {
            int total = vals[i] + carry;
            vals[i] = total % 10;
            carry = total / 10;
        }
        StringBuilder sb = new StringBuilder(m + n);
        int start = vals[0] == 0 ? 1 : 0;
        for (int i = start; i < vals.length; i++) {
            sb.append(vals[i]);
        }
        return sb.toString();
    }
}