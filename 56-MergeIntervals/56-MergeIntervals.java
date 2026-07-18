// Last updated: 7/18/2026, 9:00:58 PM
class Solution {
    public int[][] merge(int[][] intervals) {
            int max = 0;
        for (int[] inte : intervals) {
            max = Math.max(max, inte[0]);
        }

        int[] map = new int[max + 1];
        for (int[] inte : intervals) {
            int start = inte[0];
            int end = inte[1];
            map[start] = Math.max(end + 1, map[start]);
        }

        int mergeCount = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                if (start == -1) {
                    start = i;
                }

                end = Math.max(end, map[i] - 1);
            }

            if (i == end) {
                intervals[mergeCount++] = new int[] { start, end };
                start = -1;
                end = -1;
            }
        }

        if (start != -1) {
            intervals[mergeCount++] = new int[] { start, end };
        }

        int[][] res = new int[mergeCount][];

        for (int i = 0; i < mergeCount; i++) {
            res[i] = intervals[i];
        }

        return res;
    }
}