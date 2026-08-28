// Last updated: 8/28/2026, 11:04:19 PM
import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();

            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int numWords = j - i;
            StringBuilder sb = new StringBuilder();

            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int totalSpaces = maxWidth - (lineLength - (numWords - 1));
                int spacesBetween = totalSpaces / (numWords - 1);
                int extraSpaces = totalSpaces % (numWords - 1);

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spacesBetween + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}