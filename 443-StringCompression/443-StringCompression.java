// Last updated: 7/17/2026, 3:03:25 PM
class Solution {
    public int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char current = chars[read];
            int count = 0;
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }
            chars[write++] = current;
            if (count > 1) {

                String num = String.valueOf(count);

                for (char c : num.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}