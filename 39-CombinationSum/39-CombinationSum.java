// Last updated: 7/18/2026, 8:01:06 AM
1import java.util.AbstractList;
2import java.util.ArrayList;
3import java.util.List;
4
5class Solution {
6private void combinations2(int index, int[] arr, int target, List<Integer> subset, List<List<Integer>> res){
7        if(target == 0){
8            res.add(List.copyOf(subset));
9            return;
10        }
11
12        for(int i = index; i < arr.length; i++){
13            if(i > index && arr[i] == arr[i-1]){
14                continue;
15            }
16            if (arr[i] > target) {
17                break;
18            }
19            subset.add(arr[i]);
20            combinations2(i + 1, arr, target - arr[i], subset, res);
21            subset.removeLast();
22        }
23    }
24
25    private void getResults(int[] arr, int sum, List<List<Integer>> result) {
26        java.util.Arrays.sort(arr);
27        combinations2(0, arr, sum, new ArrayList<>(), result);
28    }
29
30    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
31        return new AbstractList<List<Integer>>() {
32            List<List<Integer>> res;
33
34            private void init(){
35                res = new java.util.ArrayList<>();
36                getResults(candidates, target,res);
37            }
38
39            @Override
40            public List<Integer> get(int index) {
41                return res.get(index);
42            }
43
44            @Override
45            public int size() {
46                if(res == null){
47                    init();
48                }
49                return res.size();
50            }
51        };
52    }
53}