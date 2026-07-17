// Last updated: 7/17/2026, 3:03:29 PM
class Solution {
    public String toHex(int num) {
        // String ans = "";
        // if (num < 0) {
        //     System.out.println("2s compliment - " + (long) (Math.pow(2,32)+num));
        //     return hexa((long)Math.pow(2,32)+(long)num);
        // } else {
        //     return hexa((long) num);
        // }

        if(num == 0){
            return "0";
        }
        long val = num;
        if(num < 0){
            val = (long) (Math.pow(2,32) + num);
        }
        
        StringBuilder res = new StringBuilder();
        while (val != 0){
            int remainder = (int)(val%16); //(int) (val - (((int) (val / 16)) * 16));
            val = val /16;
            if(remainder >= 10){
                res.append((char) (remainder + 87));
            }else {
                res.append(remainder);
            }
        }

        return res.reverse().toString();
    }

    public String hexa(long num) {
        String[] hex = { "a", "b", "c", "d", "e", "f" };
        String ans = "";
        while (num >= 16) {
            ans = ans + Long.toString((num / 16));
            num %= 16;
        }
        if (num < 10) {
            ans = ans + Long.toString(num);
        } else {
            ans += (hex[(int)(num % 10)]);
        }
        return ans;
    }
}