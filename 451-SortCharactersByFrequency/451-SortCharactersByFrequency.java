// Last updated: 7/17/2026, 3:03:22 PM
class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[] freq = new int[128];

        for(char c : s.toCharArray())
            freq[c]++;

        char[] result = new char[n];

        int ind = 0;

        while(ind < n) {
            int maxFreq = 0;
            char maxChar = 0;

            for(int i=0;i<128;i++) {
                if(maxFreq < freq[i]) {
                    maxFreq = freq[i];
                    maxChar = (char) i;
                }
            }

            while(maxFreq-- > 0) {
                result[ind++] = maxChar;
            }

            freq[maxChar] = 0;
        }

        return new String(result);
    }
}