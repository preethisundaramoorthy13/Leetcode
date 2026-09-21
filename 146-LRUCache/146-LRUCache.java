// Last updated: 9/21/2026, 5:57:21 PM
1import java.util.Arrays;
2
3class Solution {
4    public int maximumGap(int[] nums) {
5        if (nums == null || nums.length < 2) {
6            return 0;
7        }
8
9        int min = nums[0];
10        int max = nums[0];
11        for (int num : nums) {
12            min = Math.min(min, num);
13            max = Math.max(max, num);
14        }
15
16        if (min == max) {
17            return 0;
18        }
19
20        int n = nums.length;
21        int bucketSize = Math.max(1, (max - min) / (n - 1));
22        int bucketCount = (max - min) / bucketSize + 1;
23
24        int[] minBucket = new int[bucketCount];
25        int[] maxBucket = new int[bucketCount];
26        Arrays.fill(minBucket, Integer.MAX_VALUE);
27        Arrays.fill(maxBucket, Integer.MIN_VALUE);
28
29        for (int num : nums) {
30            int idx = (num - min) / bucketSize;
31            minBucket[idx] = Math.min(minBucket[idx], num);
32            maxBucket[idx] = Math.max(maxBucket[idx], num);
33        }
34
35        int maxGap = 0;
36        int prevMax = min;
37
38        for (int i = 0; i < bucketCount; i++) {
39            if (minBucket[i] == Integer.MAX_VALUE) {
40                continue;
41            }
42            maxGap = Math.max(maxGap, minBucket[i] - prevMax);
43            prevMax = maxBucket[i];
44        }
45
46        return maxGap;
47    }
48}