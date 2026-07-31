// Last updated: 7/31/2026, 9:42:49 AM
import java.util.AbstractList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        return new AbstractList<String>() {
            @Override
            public String get(int index) {
                int i = index + 1;
                if (i % 15 == 0) return "FizzBuzz";
                if (i % 3 == 0) return "Fizz";
                if (i % 5 == 0) return "Buzz";
                return String.valueOf(i);
            }

            @Override
            public int size() {
                return n;
            }
        };
    }
}