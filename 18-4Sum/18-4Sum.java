// Last updated: 7/17/2026, 9:48:43 PM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<List<Integer>> fourSum(int[] nums, int target) {
7        List<List<Integer>> result = new ArrayList<>();
8        
9        // Edge case: A quadruplet requires at least 4 numbers
10        if (nums == null || nums.length < 4) {
11            return result;
12        }
13        
14        // 1. Sort the array
15        Arrays.sort(nums);
16        int n = nums.length;
17        
18        // 2. First pointer loop
19        for (int i = 0; i < n - 3; i++) {
20            // Skip duplicate values for the first element
21            if (i > 0 && nums[i] == nums[i - 1]) {
22                continue;
23            }
24            
25            // 3. Second pointer loop
26            for (int j = i + 1; j < n - 2; j++) {
27                // Skip duplicate values for the second element
28                if (j > i + 1 && nums[j] == nums[j - 1]) {
29                    continue;
30                }
31                
32                int left = j + 1;
33                int right = n - 1;
34                
35                // 4. Two-pointer traversal for the remaining two elements
36                while (left < right) {
37                    // Use long to prevent integer overflow from large test cases
38                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
39                    
40                    if (sum == target) {
41                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
42                        
43                        // Skip duplicates for the third element
44                        while (left < right && nums[left] == nums[left + 1]) {
45                            left++;
46                        }
47                        // Skip duplicates for the fourth element
48                        while (left < right && nums[right] == nums[right - 1]) {
49                            right--;
50                        }
51                        
52                        // Move both pointers inward
53                        left++;
54                        right--;
55                    } else if (sum < target) {
56                        left++; // Increase the sum
57                    } else {
58                        right--; // Decrease the sum
59                    }
60                }
61            }
62        }
63        
64        return result;
65    }
66}